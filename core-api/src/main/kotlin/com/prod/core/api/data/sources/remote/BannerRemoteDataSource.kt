package com.prod.core.api.data.sources.remote

import com.prod.core.api.domain.models.banner.BannerInfo

/**
 * Интерфейс для получения данных баннера из API
 */
interface BannerRemoteDataSource {

    /**
     * Получить баннер
     * @return информация о баннере
     */
    fun getBanner(): BannerInfo
}
