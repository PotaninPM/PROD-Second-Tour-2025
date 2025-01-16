package com.prod.core.api.ui.payment

/**
 * Состояние платежа
 * @param cardNumber номер карты
 * @param cardDate дата карты
 * @param cardCvv CVV карты
 * @param isCardNumberValid флаг валидности номера карты
 * @param isCardDateValid флаг валидности даты карты
 * @param isCardCvvValid флаг валидности CVV карты
 * @param isPaymentAvailable флаг доступности оплаты
 */
data class PaymentState(
    val cardNumber: String,
    val cardDate: String,
    val cardCvv: String,
    val isCardNumberValid: Boolean,
    val isCardDateValid: Boolean,
    val isCardCvvValid: Boolean,
    val isPaymentAvailable: Boolean
)
