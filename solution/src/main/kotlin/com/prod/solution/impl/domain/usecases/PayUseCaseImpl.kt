package com.prod.solution.impl.domain.usecases

import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.domain.repositories.PayRepository
import com.prod.core.api.domain.usecases.PayUseCase
import com.prod.core.api.ui.payment.PaymentState

/**
 * Задача 10. Реализуйте UseCase для оплаты товаров
 */
class PayUseCaseImpl(
    private val payRepository: PayRepository,
    private val cartRepository: CartRepository
) : PayUseCase {

    /**
     * Метод для оплаты товаров
     * Необходимо собрать все данные из корзины и данные карты
     * И передать их в payRepository
     */
    override fun pay(paymentState: PaymentState) {
        TODO("Implementation here")
    }
}
