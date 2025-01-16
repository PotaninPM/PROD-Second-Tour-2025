package com.prod.core.api.domain.usecases

import com.prod.core.api.ui.payment.PaymentState

/**
 * Интерфейс UseCase для оплаты
 */
interface PayUseCase {

    /**
     * Оплатить
     * @param paymentState текущее состояние платежа
     */
    fun pay(paymentState: PaymentState)
}
