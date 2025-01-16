package com.prod.core.api.ui.cart

import com.prod.core.api.domain.models.GoodCartInfo

/**
 * Состояние экрана корзины
 * @param totalCosts общая стоимость
 * @param totalBonuses общее количество бонусов
 * @param totalCashback общий кэшбэк
 * @param totalWeight общий вес
 * @param goodsData информация о товарах
 */
data class CartScreenState(
    val totalCosts: Int,
    val totalBonuses: Int,
    val totalCashback: Int,
    val totalWeight: Double,
    val goodsData: List<GoodCartInfo>,
)
