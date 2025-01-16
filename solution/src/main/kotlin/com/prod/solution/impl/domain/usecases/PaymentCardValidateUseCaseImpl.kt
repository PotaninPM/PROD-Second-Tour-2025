package com.prod.solution.impl.domain.usecases

import com.prod.core.api.domain.usecases.PaymentCardValidateUseCase
import com.prod.core.api.ui.payment.PaymentState

/**
 * Задача 10. Реализуйте UseCase для валидации данных карты
 */
class PaymentCardValidateUseCaseImpl : PaymentCardValidateUseCase {

    /*
    * Метод для валидации номера карты
    * Необходимо проверить правильность введенного номера карты
    * И вернуть обновленный PaymentState
     */
    override fun validateCardNumber(
        paymentState: PaymentState,
        cardNumber: String
    ): PaymentState {
        TODO("Implementation here")
    }

    /*
    * Метод для валидации даты карты
    * Необходимо проверить правильность введенной даты карты
    * И вернуть обновленный PaymentState
     */
    override fun validateCardDate(
        paymentState: PaymentState,
        cardDate: String,
        currentYear: Int,
        currentMonth: Int
    ): PaymentState {
        TODO("Implementation here")
    }

    /*
    * Метод для валидации CVV карты
    * Необходимо проверить правильность введенного CVV карты
    * И вернуть обновленный PaymentState
     */
    override fun validateCardCvv(
        paymentState: PaymentState,
        cardCvv: String
    ): PaymentState {
        TODO("Implementation here")
    }
}
