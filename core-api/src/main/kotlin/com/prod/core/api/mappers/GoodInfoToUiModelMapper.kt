package com.prod.core.api.mappers

import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.ui.goods.GoodsItemUi

/**
 * Маппер для преобразования информации о товаре в UI модель
 */
interface GoodInfoToUiModelMapper {

    /**
     * Преобразовать информацию о товаре в UI модель
     * @param goods информация о баннере
     * @param quantity количество товара в корзине
     * @param userInfo информация о пользователе
     * @param bonusInfo выбранный бонус для товара
     * @return UI модель карточки товара
     */
    fun mapGoodInfoToUiModel(
        goods: GoodInfo,
        quantity: Int,
        userInfo: UserInfo,
        bonusInfo: BonusInfo?,
    ): GoodsItemUi
}
