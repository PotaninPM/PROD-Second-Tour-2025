package com.prod.solution.impl.data.sources.local

import com.prod.core.api.data.sources.local.GoodsLocalDataSource
import com.prod.core.api.domain.models.GoodInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о товарах из локального хранилища
 * (достаточно будет хранить их в переменной)
 */
class GoodsLocalDataSourceImpl : GoodsLocalDataSource {

    /**
     * Метод кеширует информацию о товарах
     */
    override fun cacheGoods(goods: List<GoodInfo>) {
        TODO("Implementation here")
    }

    /**
     * Метод возвращает закешированную информацию
     */
    override fun getCachedGoods(): List<GoodInfo> {
        TODO("Implementation here")
    }
}
