package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.BannerRemoteDataSource
import com.prod.core.api.domain.models.banner.BannerInfo

/**
 * Задача 1. Реализуйте сервис для получения данных баннера из API
 */
class BannerRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : BannerRemoteDataSource {

    /**
     * Метод для получения данных баннера из API
     * Необходимо получить данные из jsonProvider
     * И вернуть BannerInfo
     */
    override fun getBanner(): BannerInfo {
        TODO("Implementation here")
    }
}
