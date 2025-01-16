package com.prod.core.api.domain.usecases

import com.prod.core.api.ui.payment.PaymentState

/**
 * Интерфейс UseCase для валидации данных карты
 */
interface PaymentCardValidateUseCase {

    /**
     * Проверить номер карты
     * @param paymentState текущее состояние платежа
     * @param cardNumber номер карты
     * @return новое состояние платежа
     */
    fun validateCardNumber(
        paymentState: PaymentState,
        cardNumber: String
    ): PaymentState

    /**
     * Проверить дату карты
     * @param paymentState текущее состояние платежа
     * @param cardDate дата карты
     * @param currentYear текущий год
     * @param currentMonth текущий месяц
     * @return новое состояние платежа
     */
    fun validateCardDate(
        paymentState: PaymentState,
        cardDate: String,
        currentYear: Int,
        currentMonth: Int
    ): PaymentState

    /**
     * Проверить CVV карты
     * @param paymentState текущее состояние платежа
     * @param cardCvv CVV карты
     * @return новое состояние платежа
     */
    fun validateCardCvv(
        paymentState: PaymentState,
        cardCvv: String
    ): PaymentState
}
