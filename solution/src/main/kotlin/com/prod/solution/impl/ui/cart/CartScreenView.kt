package com.prod.solution.impl.ui.cart

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prod.core.api.Const
import com.prod.core.api.domain.models.GoodCartInfo
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.ui.cart.CartScreenState
import com.prod.core.api.ui.extensions.imageIdToResId
import com.prod.solution.databinding.CartViewBinding
import com.prod.solution.databinding.ItemCartGoodBinding
import java.text.NumberFormat
import java.util.Locale

/**
 * Задача 8. Реализуйте CartScreenView для показа экрана корзины целиком.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class CartScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val binding = CartViewBinding.inflate(LayoutInflater.from(context), this, true)

    private val cartAdapter = CartAdapter()

    init {
        binding.rvCartItems.adapter = cartAdapter
        binding.rvCartItems.layoutManager = LinearLayoutManager(context)

        val margin = (10 * resources.displayMetrics.density).toInt()
        binding.rvCartItems.addItemDecoration(ItemDec(margin))
    }

    /**
     * Метод для обновления состояния экрана корзины.
     * Принимает состояние экрана и на основе него отрисовывает нужные данные
     * @param state - состояние экрана
     * @param onDeleteGood - колбэк для удаления товара, передавать в него экземляр класса товара. Вызывать
     * по клику на кнопку удаления товара с мусоркой.
     * @param onBuyButtonClicked - колбэк для открытия экрана оплаты. Вызывать при нажатии на кнопку
     * "Купить".
     */
    fun updateState(
        state: CartScreenState,
        onDeleteGood: (GoodInfo) -> Unit,
        onBuyButtonClicked: () -> Unit
    ) {
        val totalCost = NumberFormat.getNumberInstance(Locale("ru")).format(state.totalCosts)
        binding.tvTotalPrice.text = "$totalCost ₽"

        binding.tvTotalWeight.text = String.format(Locale("ru"), "%.1f кг", state.totalWeight)

        val cashbeck = NumberFormat.getNumberInstance(Locale("ru")).format(state.totalCashback)

        if (state.totalCashback == 0) {
            binding.cashback.visibility = GONE
        } else {
            binding.tvCashback.text = "$cashbeck ₽"
            binding.cashback.visibility = VISIBLE
        }

        if (state.totalBonuses == 0) {
            binding.bonuses.visibility = GONE
        } else {
            val bonusesFormatted = NumberFormat.getNumberInstance(Locale("ru")).format(state.totalBonuses)
            binding.tvBonuses.text = "$bonusesFormatted баллов"
            binding.bonuses.visibility = VISIBLE
        }

        cartAdapter.updateData(state.goodsData, onDeleteGood)

        binding.btnBuy.setOnClickListener {
            onBuyButtonClicked()
        }
    }


    private class CartAdapter : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

        private val items = mutableListOf<GoodCartInfo>()
        private var onDeleteGood: ((GoodInfo) -> Unit)? = null

        fun updateData(newItems: List<GoodCartInfo>, onDeleteGood: (GoodInfo) -> Unit) {
            this.items.clear()
            this.items.addAll(newItems)
            this.onDeleteGood = onDeleteGood
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemCartGoodBinding.inflate(inflater, parent, false)
            return CartViewHolder(binding)
        }

        override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
            holder.bind(items[position], onDeleteGood)
        }

        override fun getItemCount(): Int = items.size

        class CartViewHolder(private val binding: ItemCartGoodBinding) :
            RecyclerView.ViewHolder(binding.root) {

            fun bind(item: GoodCartInfo, onDeleteGood: ((GoodInfo) -> Unit)?) {
                binding.tvGoodName.text = item.goodInfo.name

                val price = NumberFormat.getNumberInstance(Locale("ru")).format(item.totalCost)
                binding.tvGoodPrice.text = "$price ₽"

                val type = when (item.goodInfo.goodItemQuantityInfo.type) {
                    Const.TYPE_KILO -> "кг."
                    Const.TYPE_GRAMM -> "г."
                    else -> ""
                }

                binding.tvGoodWeight.text = when (item.goodInfo.goodItemQuantityInfo.type) {
                    Const.TYPE_KILO -> "${item.goodInfo.goodItemQuantityInfo.value * item.countInCart}кг"
                    Const.TYPE_GRAMM -> "${item.goodInfo.goodItemQuantityInfo.value * item.countInCart}г"
                    else -> ""
                }

                binding.tvGoodDetails.text = "${item.countInCart} шт.(по ${item.goodInfo.goodItemQuantityInfo.value}$type)* ${item.goodInfo.cost} ₽"
                val imageRes = imageIdToResId(item.goodInfo.imageId)

                binding.ivGoodImage.setImageResource(imageRes)

                binding.btnDelete.setOnClickListener {
                    onDeleteGood?.invoke(item.goodInfo)
                }
            }
        }
    }

    private class ItemDec(private val margin: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val position = parent.getChildAdapterPosition(view)
            val itemC = state.itemCount

            if (position != itemC - 1) {
                outRect.bottom = margin
            }
        }
    }
}

