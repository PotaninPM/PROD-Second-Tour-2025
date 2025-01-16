package com.prod.core.api.domain.usecases

import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.GoodInfo

/**
 * Интерфейс UseCase для выбора подходящего бонуса для конкретного товара
 */
interface GetBonusInfoFromGoodInfoUseCase {

    /**
     * Получить бонус для товара
     * @param goodInfo информация о товаре
     * @return подходящий бонус для товара
     */
    fun getBonusInfo(goodInfo: GoodInfo): BonusInfo?
}
