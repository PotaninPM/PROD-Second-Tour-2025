package com.prod.core.api.domain.models

/**
 * Информация о товаре в корзине
 * @param goodInfo информация о товаре
 * @param quantityValue количество товара
 * @param totalCost общая стоимость
 * @param countInCart количество товара в корзине
 */
data class GoodCartInfo(
    val goodInfo: GoodInfo,
    val quantityValue: Int,
    val totalCost: Int,
    val countInCart: Int
)
