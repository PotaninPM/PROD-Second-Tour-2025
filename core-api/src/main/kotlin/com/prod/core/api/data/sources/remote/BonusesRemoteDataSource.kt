package com.prod.core.api.data.sources.remote

import com.prod.core.api.domain.models.BonusInfo

/**
 * Интерфейс для получения данных по бонусам из API
 */
interface BonusesRemoteDataSource {

    /**
     * Получить все бонусы
     * @return список бонусов
     */
    fun getAllBonuses(): List<BonusInfo>
}
