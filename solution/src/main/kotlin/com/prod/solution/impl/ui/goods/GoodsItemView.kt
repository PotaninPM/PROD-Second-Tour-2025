package com.prod.solution.impl.ui.goods

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.prod.core.api.ui.extensions.dpToPx
import com.prod.core.api.ui.goods.GoodsItemUi
import com.prod.solution.databinding.GoodsItemViewBinding

/**
 * Задача 6. Реализуйте GoodsItemView для показа баннера.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class GoodsItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: GoodsItemViewBinding = GoodsItemViewBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    /**
     * Метод для инициализации товара.
     * Принимает состояние и на основе него отрисовывает нужные данные
     * @param item - модель товара
     */
    fun updateState(item: GoodsItemUi) {
        with(binding) {
            ivGoodsImage.setImageResource(item.imageRes)

            tvTopLabel.text = item.bonus?.text
            tvTopLabel.visibility = if (item.bonus == null) {
                GONE
            } else {
                VISIBLE
            }

            item.bonus?.let { bonus ->
                tvTopLabel.setTextColor(bonus.textColor)
                bonus.backgroundColor.let { bgColor ->
                    val background = tvTopLabel.background.mutate() as? GradientDrawable
                    background?.setColor(bgColor)
                }
                bonus.borderColor.let { borderColor ->
                    val background = tvTopLabel.background.mutate() as? GradientDrawable
                    if (borderColor != null) {
                        background?.setStroke(context.dpToPx(1.0f), borderColor)
                    } else {
                        background?.setStroke(0, borderColor)
                    }
                }
            }

            tvBottomLabel.text = item.favourite?.text
            tvBottomLabel.visibility = if (item.favourite == null) {
                GONE
            } else {
                VISIBLE
            }

            item.favourite?.let { favourite ->
                tvBottomLabel.setTextColor(favourite.textColor)
            }

            tvGoodsTitle.text = item.name
            tvManufacturer.text = item.producerName
            tvGoodsWeight.text = item.quantityInfo
            tvGoodsPrice.text = item.cost
        }
    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setAddToCartButtonClickListener(onClick: () -> Unit) {
        binding.btnAddToCart.setOnClickListener { onClick() }
    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setIncreaseQuantityClickListener(onClick: () -> Unit) {
        //binding.btnIncreaseQuantity.setOnClickListener { onClick() }
    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setDecreaseQuantityClickListener(onClick: () -> Unit) {
        //binding.btnDecreaseQuantity.setOnClickListener { onClick() }
    }
}
