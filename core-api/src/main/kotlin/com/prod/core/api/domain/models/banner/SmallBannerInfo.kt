package com.prod.core.api.domain.models.banner

/**
 * Информация о маленьком баннере
 * @param priority приоритет баннера
 * @param rightLabel правый заголовок
 * @param leftLabel левый заголовок
 */
data class SmallBannerInfo(
    val priority: Int,
    val rightLabel: String,
    val leftLabel: String,
    val imageId: String,
)
