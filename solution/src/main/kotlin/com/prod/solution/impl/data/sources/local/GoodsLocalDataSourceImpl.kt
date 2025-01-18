package com.prod.solution.impl.data.sources.local

import com.prod.core.api.data.sources.local.GoodsLocalDataSource
import com.prod.core.api.domain.models.GoodInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о товарах из локального хранилища
 * (достаточно будет хранить их в переменной)
 */
class GoodsLocalDataSourceImpl : GoodsLocalDataSource {

    private val cachedG: MutableList<GoodInfo> = mutableListOf()

    /**
     * Метод кеширует информацию о товарах
     */
    override fun cacheGoods(goods: List<GoodInfo>) {
        cachedG.clear()
        cachedG.addAll(goods)
    }

    /**
     * Метод возвращает закешированную информацию
     */
    override fun getCachedGoods(): List<GoodInfo> {
        return cachedG.toList()
    }
}
