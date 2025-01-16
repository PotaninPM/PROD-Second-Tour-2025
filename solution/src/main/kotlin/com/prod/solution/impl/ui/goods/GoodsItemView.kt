package com.prod.solution.impl.ui.goods

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.prod.core.api.ui.goods.GoodsItemUi

/**
 * Задача 6. Реализуйте GoodsItemView для показа баннера.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class GoodsItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    /**
     * Метод для инициализации товара.
     * Принимает состояние и на основе него отрисовывает нужные данные
     * @param item - модель товара
     */
    fun updateState(item: GoodsItemUi) {

    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setAddToCartButtonClickListener(onClick: () -> Unit) {

    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setIncreaseQuantityClickListener(onClick: () -> Unit) {

    }

    /**
     * Метод для установки колбэка в нужную кнопку
     */
    fun setDecreaseQuantityClickListener(onClick: () -> Unit) {

    }
}
