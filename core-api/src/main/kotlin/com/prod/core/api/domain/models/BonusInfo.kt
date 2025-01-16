package com.prod.core.api.domain.models

import java.util.Date

/**
 * Информация о бонусе
 * @param id идентификатор бонуса
 * @param type тип бонуса
 * @param value значение бонуса
 * @param availableDueTo доступно до
 * @param promotionExtra дополнительная информация о промо-акции
 */
data class BonusInfo(
    val id: String,
    val type: String,
    val value: Double,
    val availableDueTo: Date? = null,
    val promotionExtra: PromotionExtra? = null,
)
