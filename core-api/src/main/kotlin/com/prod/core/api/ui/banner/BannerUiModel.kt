package com.prod.core.api.ui.banner

/**
 * UI модель для баннера
 * @param largeBanner модель большого баннера
 * @param smallBanner модель маленького баннера
 */
data class BannerUiModel(
    val largeBanner: LargeBannerUiModel,
    val smallBanner: SmallBannerUiModel?
)

/**
 * UI модель для большого баннера
 * @param isFirstInPriority признак того, что баннер должен быть первым
 * @param title заголовок баннера
 * @param description описание баннера
 */
data class LargeBannerUiModel(
    val isFirstInPriority: Boolean,
    val title: String,
    val description: String,
    val imageResId: Int
)

/**
 * UI модель для маленького баннера
 * @param isFirstInPriority признак того, что баннер должен быть первым
 * @param rightLabel правый заголовок
 * @param leftLabel левый заголовок
 */
data class SmallBannerUiModel(
    val isFirstInPriority: Boolean,
    val rightLabel: String,
    val leftLabel: String,
    val imageResId: Int
)
