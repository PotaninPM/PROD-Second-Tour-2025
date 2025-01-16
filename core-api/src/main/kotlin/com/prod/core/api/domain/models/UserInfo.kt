package com.prod.core.api.domain.models

/**
 * Информация о пользователе
 * @param lastGoodsCategories последние категории товаров
 * @param availableBonuses доступные бонусы
 * @param favorites избранное
 * @param activityLevel уровень активности пользователя
 */
data class UserInfo(
    val lastGoodsCategories: List<String>,
    val availableBonuses: List<String>,
    val favorites: List<String>,
    val activityLevel: Int,
)
