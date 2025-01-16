package com.prod.core.api.domain.models.banner

/**
 * Информация о баннере
 * @param large информация о большом баннере
 * @param small информация о маленьком баннере
 */
data class BannerInfo(
    val large: LargeBannerInfo,
    val small: SmallBannerInfo?
)
