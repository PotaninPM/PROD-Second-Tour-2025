package com.prod.solution.impl.sorter

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.sorter.GoodsInfoSorter
import com.prod.core.api.sorter.GoodsScoreCalculator

/**
 * Задача 5. Реализуйте сортировщик товаров в соответствии с задачей.
 */
class GoodsInfoSorterImpl(
    private val goodsScoreCalculator: GoodsScoreCalculator,
) : GoodsInfoSorter {

    /**
     * Метод возвращает отсортированную информацию о товарах
     */
    override fun sortGoodsInfo(goods: List<GoodInfo>, userInfo: UserInfo): List<GoodInfo> {
        TODO("Implementation here")
    }
}
