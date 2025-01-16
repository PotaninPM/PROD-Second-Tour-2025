package com.prod.core.impl.ui.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.prod.core.api.domain.usecases.PayUseCase
import com.prod.core.api.domain.usecases.PaymentCardValidateUseCase
import com.prod.core.api.ui.payment.PaymentState
import com.prod.core.impl.AppServiceHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class PaymentViewModel(
    private val paymentCardValidateUseCase: PaymentCardValidateUseCase,
    private val payUseCase: PayUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(
        PaymentState(
            cardNumber = "",
            cardDate = "",
            cardCvv = "",
            isCardNumberValid = true,
            isCardDateValid = true,
            isCardCvvValid = true,
            isPaymentAvailable = true
        )
    )
    val state = _state.asStateFlow()

    fun onCardNumberChanged(cardNumber: String) {
        paymentCardValidateUseCase.validateCardNumber(state.value, cardNumber).let { newState ->
            viewModelScope.launch(Dispatchers.Default) {
                _state.value = newState
            }
        }
    }

    fun onCardDateChanged(cardDate: String) {
        paymentCardValidateUseCase.validateCardDate(
            paymentState = state.value,
            cardDate = cardDate,
            currentMonth = 1,
            currentYear = 2025
        ).let { newState ->
            viewModelScope.launch(Dispatchers.Default) {
                _state.value = newState
            }
        }
    }

    fun onCardCvvChanged(cardCvv: String) {
        paymentCardValidateUseCase.validateCardCvv(state.value, cardCvv).let { newState ->
            viewModelScope.launch(Dispatchers.Default) {
                _state.value = newState
            }
        }
    }

    fun onPayButtonClicked(paymentState: PaymentState) {
        payUseCase.pay(paymentState)
    }
}

internal class PaymentViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PaymentViewModel::class.java)) {
            return PaymentViewModel(
                paymentCardValidateUseCase = AppServiceHolder.appService.paymentCardValidateUseCase,
                payUseCase = AppServiceHolder.appService.payUseCase
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
