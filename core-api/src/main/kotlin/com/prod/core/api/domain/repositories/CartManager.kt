package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.GoodCartInfo

/**
 * Менеджер корзины
 */
interface CartManager {

    /**
     * Рассчитать стоимость товаров
     * @return стоимость товаров
     */
    fun calculateCosts(): Int

    /**
     * Рассчитать бонусы
     * @return количество бонусов
     */
    fun calculateBonuses(): Int

    /**
     * Рассчитать кэшбэк
     * @return количество кэшбэка
     */
    fun calculateCashback(): Int

    /**
     * Рассчитать информацию о товарах
     * @return список информации о товарах
     */
    fun calculateGoodsData(): List<GoodCartInfo>

    /**
     * Рассчитать общий вес в килограммах
     * @return общий вес в килограммах
     */
    fun calculateAllWeight(): Double
}
