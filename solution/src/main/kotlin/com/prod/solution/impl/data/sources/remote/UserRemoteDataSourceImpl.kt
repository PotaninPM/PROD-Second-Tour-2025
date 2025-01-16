package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.UserRemoteDataSource
import com.prod.core.api.domain.models.UserInfo

/**
 * Задача 4. Реализуйте сервис для получения данных о пользователе из API
 */
class UserRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : UserRemoteDataSource {

    /**
     * Метод для получения данных о пользователе из API
     * Необходимо получить данные из jsonProvider
     * И вернуть UserInfo
     */
    override fun getUserInfo(): UserInfo {
        TODO("Implementation here")
    }
}
