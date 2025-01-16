package com.prod.core.impl.ui.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.CartManager
import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.ui.cart.CartScreenState
import com.prod.core.impl.AppServiceHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

internal class CartFragmentViewModel(
    private val cartRepository: CartRepository,
    private val cartManager: CartManager,
) : ViewModel() {

    private val _state = MutableStateFlow(
        CartScreenState(
            totalCosts = 0,
            totalBonuses = 0,
            totalCashback = 0,
            totalWeight = 0.0,
            goodsData = emptyList()
        )
    )
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            _state.value = state.value.copy(
                totalCosts = cartManager.calculateCosts(),
                totalBonuses = cartManager.calculateBonuses(),
                totalCashback = cartManager.calculateCashback(),
                totalWeight = cartManager.calculateAllWeight(),
                goodsData = cartManager.calculateGoodsData()
            )
        }
    }

    fun deleteGoodFromCart(goodInfo: GoodInfo) {
        cartRepository.deleteAllQuantitiesFromCart(goodInfo)
        viewModelScope.launch(Dispatchers.Default) {
            _state.value = state.value.copy(
                totalCosts = cartManager.calculateCosts(),
                totalBonuses = cartManager.calculateBonuses(),
                totalCashback = cartManager.calculateCashback(),
                totalWeight = cartManager.calculateAllWeight(),
                goodsData = cartManager.calculateGoodsData()
            )
        }
    }
}

internal class CartViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartFragmentViewModel::class.java)) {
            return CartFragmentViewModel(
                cartRepository = AppServiceHolder.appService.cartRepository,
                cartManager = AppServiceHolder.appService.cartManager
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
