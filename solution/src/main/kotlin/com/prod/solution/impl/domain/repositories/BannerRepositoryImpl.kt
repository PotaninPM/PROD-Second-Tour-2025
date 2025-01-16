package com.prod.solution.impl.domain.repositories

import com.prod.core.api.data.sources.remote.BannerRemoteDataSource
import com.prod.core.api.domain.models.banner.BannerInfo
import com.prod.core.api.domain.repositories.BannerRepository

/**
 * Задача 1. Реализуйте сервис для получения данных баннера из API
 */
class BannerRepositoryImpl(private val remoteDataSource: BannerRemoteDataSource) : BannerRepository {

    /**
     * Метод для получения данных баннера из API
     * Необходимо получить данные из remoteDataSource
     * И вернуть BannerInfo
     */
    override fun getBannerInfo(): BannerInfo {
        TODO("Implementation here")
    }
}
