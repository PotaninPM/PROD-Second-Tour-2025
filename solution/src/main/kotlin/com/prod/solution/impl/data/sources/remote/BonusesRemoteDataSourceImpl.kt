package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.BonusesRemoteDataSource
import com.prod.core.api.domain.models.BonusInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о бонусах из API
 */
class BonusesRemoteDataSourceImpl(
    private val jsonProvider: JsonProvider,
) : BonusesRemoteDataSource {

    /**
     * Метод для получения данных о бонусах из API
     * Необходимо получить данные из jsonProvider
     * И вернуть List<BonusInfo>
     */
    override fun getAllBonuses(): List<BonusInfo> {
        TODO("Implementation here")
    }
}
