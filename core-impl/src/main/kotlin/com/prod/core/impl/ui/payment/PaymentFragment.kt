package com.prod.core.impl.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.prod.core.impl.databinding.FragmentPaymentBinding
import kotlinx.coroutines.launch

fun paymentFragment(): Fragment {
    return PaymentFragment()
}

internal class PaymentFragment : Fragment() {

    private lateinit var binding: FragmentPaymentBinding
    private lateinit var viewModel: PaymentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, PaymentViewModelFactory())[PaymentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.root.updateLayoutParams<MarginLayoutParams> {
                setMargins(0, 0, 0, systemBars.bottom)
            }
            binding.screen.updatePadding(top = systemBars.top)
            insets
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    binding.screen.updatePaymentScreen(
                        paymentState = it,
                        onCardNumberChanged = { cardNumber -> viewModel.onCardNumberChanged(cardNumber) },
                        onCardDateChanged = { cardDate -> viewModel.onCardDateChanged(cardDate) },
                        onCardCvvChanged = { cardCvv -> viewModel.onCardCvvChanged(cardCvv) },
                        onPayButtonClicked = { paymentState -> viewModel.onPayButtonClicked(paymentState) }
                    )
                }
            }
        }
    }
}
