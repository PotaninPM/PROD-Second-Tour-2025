package com.prod.core.api.sorter

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo

/**
 * Интерфейс сервиса для подсчета score товара.
 */
interface GoodsScoreCalculator {

    /**
     * Метод вычисляет score для конкретного товара
     * @param goods информация о товаре
     * @param userInfo информация о пользователе
     * @return score товара
     */
    fun calculateScore(goods: GoodInfo, userInfo: UserInfo): Int
}
