package com.prod.core.impl.ui.goods

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prod.core.api.ui.goods.GoodsItemUi
import com.prod.solution.impl.ui.goods.GoodsItemView

internal class GoodsItemAdapter(
    private val onAddToCartClickListener: (GoodsItemUi) -> Unit,
    private val onIncreaseQuantityClickListener: (GoodsItemUi) -> Unit,
    private val onDecreaseQuantityClickListener: (GoodsItemUi) -> Unit,
) : ListAdapter<GoodsItemUi, GoodsItemViewHolder>(GoodsItemUiModelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoodsItemViewHolder {
        return GoodsItemViewHolder(GoodsItemView(parent.context)).apply {
            goodsItemView.setAddToCartButtonClickListener {
                onAddToCartClickListener(getItem(adapterPosition))
            }
            goodsItemView.setIncreaseQuantityClickListener {
                onIncreaseQuantityClickListener(getItem(adapterPosition))
            }
            goodsItemView.setDecreaseQuantityClickListener {
                onDecreaseQuantityClickListener(getItem(adapterPosition))
            }
        }
    }

    override fun onBindViewHolder(holder: GoodsItemViewHolder, position: Int) {
        holder.goodsItemView.updateState(getItem(position))
    }
}

internal class GoodsItemViewHolder(val goodsItemView: GoodsItemView) :
    RecyclerView.ViewHolder(goodsItemView)

internal class GoodsItemUiModelDiffCallback : DiffUtil.ItemCallback<GoodsItemUi>() {

    override fun areItemsTheSame(oldItem: GoodsItemUi, newItem: GoodsItemUi): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GoodsItemUi, newItem: GoodsItemUi): Boolean {
        return oldItem == newItem
    }
}
