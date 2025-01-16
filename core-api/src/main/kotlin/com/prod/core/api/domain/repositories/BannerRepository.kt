package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.banner.BannerInfo

/**
 * Репозиторий для получения информации о баннере
 */
interface BannerRepository {

    /**
     * Получить информацию о баннере
     * @return информация о баннере
     */
    fun getBannerInfo(): BannerInfo
}
