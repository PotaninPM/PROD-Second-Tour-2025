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
        var score = 0
        score += when {
            goods.popularity > 100 -> 3
            goods.popularity < 50 -> -1
            else -> 0
        }

        goods.rating?.let { rating ->
            score += when {
                rating > 4.5 -> 2
                rating < 3.0 -> -1
                else -> 0
            }
        }

        if (userInfo.favorites.contains(goods.id)) {
            score += 2
        }

        val categoryIndex = userInfo.lastGoodsCategories.indexOfLast { it == goods.category }
        if (categoryIndex != -1) {
            score += userInfo.lastGoodsCategories.size - 1 - categoryIndex
        }

        return score
    }
}
