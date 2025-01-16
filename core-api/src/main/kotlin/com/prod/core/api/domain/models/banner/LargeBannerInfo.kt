package com.prod.core.api.domain.models.banner

/**
 * Информация о большом баннере
 * @param priority приоритет баннера
 * @param imageId идентификатор изображения
 * @param title заголовок баннера
 * @param description описание баннера
 * @param bonus бонус баннера
 */
data class LargeBannerInfo(
    val priority: Int,
    val imageId: String,
    val title: String,
    val description: String,
    val bonus: LargeBannerBonus?
) {
    /**
     * Бонус баннера
     * @param value значение бонуса
     * @param postfix постфикс бонуса
     */
    data class LargeBannerBonus(
        val value: Int,
        val postfix: String
    )
}
