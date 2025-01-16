package com.prod.core.impl.ui.goods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.BannerRepository
import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.domain.repositories.GoodsRepository
import com.prod.core.api.domain.usecases.GetGoodsUseCase
import com.prod.core.api.mappers.BannerInfoToUiModelMapper
import com.prod.core.api.ui.banner.BannerUiModel
import com.prod.core.api.ui.banner.LargeBannerUiModel
import com.prod.core.api.ui.goods.GoodsItemUi
import com.prod.core.impl.AppServiceHolder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class GoodsViewModel(
    private val getGoodsUseCase: GetGoodsUseCase,
    private val goodsRepository: GoodsRepository,
    private val cartRepository: CartRepository,
    private val bannerRepository: BannerRepository,
    private val bannerInfoToUiModelMapper: BannerInfoToUiModelMapper
) : ViewModel() {

    private val _state = MutableStateFlow(
        GoodsScreenState(
            banner = BannerUiModel(
                largeBanner = LargeBannerUiModel(
                    isFirstInPriority = true,
                    title = "Null",
                    description = "null",
                    imageResId = 0
                ),
                smallBanner = null
            ),
            goodsList = emptyList(),
            isAddToCartButtonVisible = false,
        )
    )
    val state = _state.asStateFlow()

    fun loadData() {
        _state.value = GoodsScreenState(
            banner = bannerInfoToUiModelMapper.mapBannerInfoToUiModel(bannerRepository.getBannerInfo()),
            goodsList = getGoodsUseCase.getAllGoods(),
            isAddToCartButtonVisible = cartRepository.getCart().isNotEmpty(),
        )
    }

    fun addToCart(item: GoodsItemUi) {
        increaseGoodsQuantity(item)
    }

    fun increaseGoodsQuantity(item: GoodsItemUi) {
        getGoodInfoFromUi(item)?.let {
            cartRepository.increaseGoodQuantity(it)
        }
        loadData()
    }

    fun decreaseGoodsQuantity(item: GoodsItemUi) {
        getGoodInfoFromUi(item)?.let {
            cartRepository.decreaseGoodQuantity(it)
        }
        loadData()
    }

    private fun getGoodInfoFromUi(item: GoodsItemUi): GoodInfo? {
        return goodsRepository.getAllGoods().firstOrNull { item.id == it.id }
    }
}

internal class GoodsViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GoodsViewModel::class.java)) {
            return GoodsViewModel(
                getGoodsUseCase = AppServiceHolder.appService.getGoodsUseCase,
                goodsRepository = AppServiceHolder.appService.goodsRepository,
                cartRepository = AppServiceHolder.appService.cartRepository,
                bannerRepository = AppServiceHolder.appService.bannerRepository,
                bannerInfoToUiModelMapper = AppServiceHolder.appService.bannerInfoToUiModelMapper,
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
