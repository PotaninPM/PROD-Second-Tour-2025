package com.prod.solution.impl.domain.repositories

import com.prod.core.api.data.sources.local.BonusesLocalDataSource
import com.prod.core.api.data.sources.remote.BonusesRemoteDataSource
import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.repositories.BonusesRepository

/**
 * Задача 4. Реализуйте сервис для получения данных о бонусах
 * Важно отдавать сначала закешированные данные, если они есть.
 * А если кэша нет, то сходить в сеть и закэшировать.
 */
class BonusesRepositoryImpl(
    private val bonusesLocalDataSource: BonusesLocalDataSource,
    private val bonusesRemoteDataSource: BonusesRemoteDataSource
) : BonusesRepository {

    /**
     * Метод возвращает информацию о бонусах (или из кеша, или из локального хранилища)
     */
    override fun getAllBonuses(): List<BonusInfo> {
        TODO("Implementation here")
    }
}
