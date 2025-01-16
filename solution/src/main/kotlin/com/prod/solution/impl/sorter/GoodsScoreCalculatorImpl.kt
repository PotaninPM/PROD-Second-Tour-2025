package com.prod.solution.impl.sorter

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.sorter.GoodsScoreCalculator

/**
 * Задача 5. Реализуйте сервиса для подсчета score товара.
 */
class GoodsScoreCalculatorImpl : GoodsScoreCalculator {

    /**
     * Метод возвращает score для конкретного товара
     */
    override fun calculateScore(goods: GoodInfo, userInfo: UserInfo): Int {
        TODO("Implementation here")
    }
}
