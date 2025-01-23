package com.prod.solution.impl.ui.payment

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import androidx.core.widget.addTextChangedListener
import com.prod.core.api.ui.payment.PaymentState
import com.prod.solution.databinding.PaymentViewBinding

/**
 * Задача 11. Реализуйте PaymentScreenView для показа экрана оплаты целиком.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class PaymentScreenView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val binding: PaymentViewBinding = PaymentViewBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    /**
     * Метод для обновления состояния экрана оплаты.
     * Принимает состояние экрана и на основе него отрисовывает нужные данные
     * @param paymentState - состояние экрана
     * @param onCardNumberChanged - коллбэк для обновления номера карты
     * @param onCardDateChanged - коллбэк для обновления даты карты
     * @param onCardCvvChanged - коллбэк для обновления CVV карты
     * @param onPayButtonClicked - коллбэк для нажатия на кнопку оплаты
     */
    fun updatePaymentScreen(
        paymentState: PaymentState,
        onCardNumberChanged: (String) -> Unit,
        onCardDateChanged: (String) -> Unit,
        onCardCvvChanged: (String) -> Unit,
        onPayButtonClicked: (PaymentState) -> Unit
    ) {

        /*binding.tilCardNumber.editText?.apply {
            setText(paymentState.cardNumber)
            addTextChangedListener {
                val text = it.toString()
                onCardNumberChanged(text)
            }
        }

        binding.tvCardError.visibility = if (paymentState.isCardNumberValid) {
            View.GONE
        } else {
            View.VISIBLE
        }

        binding.tilExpDate.editText?.apply {
            setText(paymentState.cardDate)
            addTextChangedListener {
                val text = it.toString()
                onCardDateChanged(text)
            }
        }

        binding.tvExpDateError.visibility = if (paymentState.isCardDateValid) {
            View.GONE
        } else {
            View.VISIBLE
        }

        binding.tilCvv.editText?.apply {
            setText(paymentState.cardCvv)
            addTextChangedListener {
                val text = it.toString()
                onCardCvvChanged(text)
            }
        }

        binding.tvCvvError.visibility = if (paymentState.isCardCvvValid) {
            View.GONE
        } else {
            View.VISIBLE
        }

        binding.btnPay.isEnabled = paymentState.isPaymentAvailable

        binding.btnPay.setOnClickListener {
            onPayButtonClicked(paymentState)
        }*/
    }
}
