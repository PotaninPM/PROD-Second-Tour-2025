package com.prod.core.api.domain.models

/**
 * Дополнительная информация о промо-акции
 * @param baseColor основной цвет
 * @param tintColor дополнительный цвет
 * @param label название
 */
data class PromotionExtra(
    val baseColor: String,
    val tintColor: String,
    val label: String,
)
