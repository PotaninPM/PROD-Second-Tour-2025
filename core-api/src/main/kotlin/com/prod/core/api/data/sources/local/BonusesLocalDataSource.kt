package com.prod.core.api.data.sources.local

import com.prod.core.api.domain.models.BonusInfo

/**
 * Интерфейс для работы с локальным источником данных по бонусам
 * Имитирует работу с базой данных
 */
interface BonusesLocalDataSource {

    /**
     * Кешировать бонусы
     * @param bonuses список бонусов
     */
    fun cacheBonuses(bonuses: List<BonusInfo>)

    /**
     * Получить закешированные бонусы
     * @return список бонусов
     */
    fun getCachedBonuses(): List<BonusInfo>
}
