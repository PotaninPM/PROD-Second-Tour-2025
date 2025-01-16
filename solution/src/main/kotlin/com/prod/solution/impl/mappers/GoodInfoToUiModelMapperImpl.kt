package com.prod.solution.impl.mappers

import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.mappers.GoodInfoToUiModelMapper
import com.prod.core.api.ui.goods.GoodsItemUi

/**
 * Задача 5. Реализуйте маппер, который превращает сырые данные в данные, готовые для показа на экране
 */
class GoodInfoToUiModelMapperImpl : GoodInfoToUiModelMapper {

    /**
     * Метод возвращает информацию о товаре в соответствии с задачей
     */
    override fun mapGoodInfoToUiModel(
        goods: GoodInfo,
        quantity: Int,
        userInfo: UserInfo,
        bonusInfo: BonusInfo?,
    ): GoodsItemUi {
        TODO("Implementation here")
    }
}
