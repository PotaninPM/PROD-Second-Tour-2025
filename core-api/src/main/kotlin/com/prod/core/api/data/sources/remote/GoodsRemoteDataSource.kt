package com.prod.core.api.data.sources.remote

import com.prod.core.api.domain.models.GoodInfo

/**
 * Интерфейс для получения данных по товарам из API
 */
interface GoodsRemoteDataSource {

    /**
     * Получить все товары
     * @return список товаров
     */
    fun getAllGoods(): List<GoodInfo>
}
