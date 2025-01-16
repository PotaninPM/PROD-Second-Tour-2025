package com.prod.core.impl.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.impl.R
import com.prod.core.impl.databinding.FragmentCartBinding
import com.prod.core.impl.ui.payment.paymentFragment
import kotlinx.coroutines.launch

fun cartFragment(): Fragment {
    return CartFragment()
}

internal class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProvider(this, CartViewModelFactory())[CartFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onBuyButtonClickListener: () -> Unit = {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, paymentFragment())
                .addToBackStack(null)
                .commit()
        }

        val onDeleteGoodClicked: (GoodInfo) -> Unit = { goodInfo ->
            viewModel.deleteGoodFromCart(goodInfo)
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {
                    binding.screen.updateState(it, onDeleteGoodClicked, onBuyButtonClickListener)
                }
            }
        }
    }
}
