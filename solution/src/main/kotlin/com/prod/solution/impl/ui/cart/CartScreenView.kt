package com.prod.solution.impl.ui.cart

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.ui.cart.CartScreenState

/**
 * Задача 8. Реализуйте CartScreenView для показа экрана корзины целиком.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class CartScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RelativeLayout(context, attrs, defStyleAttr) {

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
        TODO("Implementation here")
    }
}
