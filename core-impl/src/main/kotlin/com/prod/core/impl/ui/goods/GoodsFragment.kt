package com.prod.core.impl.ui.goods

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.core.util.TypedValueCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updateLayoutParams
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.prod.core.impl.R
import com.prod.core.impl.databinding.FragmentGoodsBinding
import com.prod.core.impl.ui.cart.cartFragment
import kotlinx.coroutines.launch

fun goodsFragment(): Fragment {
    return GoodsFragment()
}

internal class GoodsFragment : Fragment() {

    private lateinit var binding: FragmentGoodsBinding
    private lateinit var viewModel: GoodsViewModel

    private val goodsItemAdapter = GoodsItemAdapter(
        onIncreaseQuantityClickListener = { viewModel.increaseGoodsQuantity(it) },
        onDecreaseQuantityClickListener = { viewModel.decreaseGoodsQuantity(it) },
        onAddToCartClickListener = { viewModel.addToCart(it) },
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, GoodsViewModelFactory())[GoodsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGoodsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { _, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.root.updateLayoutParams<MarginLayoutParams> {
                setMargins(0, 0, 0, systemBars.bottom)
            }
            binding.bannerView.updatePadding(top = systemBars.top)
            insets
        }

        binding.goodsList.adapter = goodsItemAdapter
        binding.btnOpenCart.background = GradientDrawable().apply {
            cornerRadius = TypedValueCompat.dpToPx(12f, resources.displayMetrics)
            setColor(Color.parseColor("#FFEC18"))
        }
        binding.btnOpenCart.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, cartFragment())
                .addToBackStack(null)
                .commit()
        }

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    binding.bannerView.setupBanner(state.banner)
                    binding.btnOpenCart.isVisible = isVisible
                    goodsItemAdapter.submitList(state.goodsList)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }
}
