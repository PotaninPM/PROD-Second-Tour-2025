package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.GoodsRemoteDataSource
import com.prod.core.api.domain.models.GoodInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о товарах из API
 */
class GoodsRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : GoodsRemoteDataSource {

    /**
     * Метод для получения данных о товарах из API
     * Необходимо получить данные из jsonProvider
     * И вернуть List<GoodInfo>
     */
    override fun getAllGoods(): List<GoodInfo> {
        TODO("Implementation here")
    }
}
