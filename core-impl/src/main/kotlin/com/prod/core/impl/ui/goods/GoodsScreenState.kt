package com.prod.core.impl.ui.goods

import com.prod.core.api.ui.banner.BannerUiModel
import com.prod.core.api.ui.goods.GoodsItemUi

data class GoodsScreenState(
    val banner: BannerUiModel,
    val goodsList: List<GoodsItemUi>,
    val isAddToCartButtonVisible: Boolean,
)
