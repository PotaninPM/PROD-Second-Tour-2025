package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.BonusInfo

/**
 * Репозиторий для получения информации о бонусах
 */
interface BonusesRepository {

    /**
     * Получить информацию о всех бонусах
     * @return список бонусов
     */
    fun getAllBonuses(): List<BonusInfo>
}
