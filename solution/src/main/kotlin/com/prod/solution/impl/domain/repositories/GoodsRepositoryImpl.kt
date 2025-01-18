package com.prod.solution.impl.domain.repositories

import com.prod.core.api.data.sources.local.GoodsLocalDataSource
import com.prod.core.api.data.sources.remote.GoodsRemoteDataSource
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.GoodsRepository

/**
 * Задача 4. Реализуйте сервис для получения данных о товарах
 * Важно отдавать сначала закешированные данные, если они есть.
 * А если кэша нет, то сходить в сеть и закэшировать.
 */
class GoodsRepositoryImpl(
    private val goodsLocalDataSource: GoodsLocalDataSource,
    private val goodsRemoteDataSource: GoodsRemoteDataSource,
) : GoodsRepository {

    /**
     * Метод возвращает информацию о товарах (или из кеша, или из локального хранилища)
     */
    override fun getAllGoods(): List<GoodInfo> {
        return goodsLocalDataSource.getCachedGoods().ifEmpty {
            val goods = goodsRemoteDataSource.getAllGoods()
            goodsLocalDataSource.cacheGoods(goods)
            goods
        }
    }
}
