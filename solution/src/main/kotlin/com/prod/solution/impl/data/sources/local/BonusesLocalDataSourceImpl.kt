package com.prod.solution.impl.data.sources.local

import com.prod.core.api.data.sources.local.BonusesLocalDataSource
import com.prod.core.api.domain.models.BonusInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о бонусах из локального хранилища
 * (достаточно будет хранить их в переменной)
 */
class BonusesLocalDataSourceImpl : BonusesLocalDataSource {

    private val cachedBon: MutableList<BonusInfo> = mutableListOf()


    /**
     * Метод кеширует информацию о бонусах
     */
    override fun cacheBonuses(bonuses: List<BonusInfo>) {
        cachedBon.clear()
        cachedBon.addAll(bonuses)
    }

    /**
     * Метод возвращает закешированную информацию
     */
    override fun getCachedBonuses(): List<BonusInfo> {
        return cachedBon.toList()
    }
}
