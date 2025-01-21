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
        val valid1 = cardNumber.replace(" ", "").length == 16
        val valid2 = cardNumber.matches(Regex("^\\d{4}( \\d{4}){3}\$"))

        val valid = valid1 && valid2

        return paymentState.copy(
            cardNumber = cardNumber,
            isCardNumberValid = valid,
            isPaymentAvailable = valid && paymentState.isCardDateValid && paymentState.isCardCvvValid
        )
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
        val valid = cardDate.matches(Regex("^\\d{2}/\\d{2}\$")) && run {
            val (month, year) = cardDate.split("/").map { it.toInt() }
            month in 1..12 && (year > currentYear % 100 || (year == currentYear % 100 && month >= currentMonth))
        }

        return paymentState.copy(
            cardDate = cardDate,
            isCardDateValid = valid,
            isPaymentAvailable = paymentState.isCardNumberValid && valid && paymentState.isCardCvvValid
        )
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
        val valid1 = cardCvv.matches(Regex("\\d{3}"))
        val valid2 = cardCvv.length == 3

        val valid = valid1 && valid2

        return paymentState.copy(
            cardCvv = cardCvv,
            isCardCvvValid = valid,
            isPaymentAvailable = paymentState.isCardNumberValid && paymentState.isCardDateValid && valid
        )
    }
}
