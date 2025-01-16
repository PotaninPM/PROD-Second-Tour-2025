package com.prod.solution.impl.domain.repositories

import com.prod.core.api.data.sources.remote.UserRemoteDataSource
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.domain.repositories.UserRepository

/**
 * Задача 4. Реализуйте сервис для получения данных о пользователе из API
 */
class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {

    /**
     * Метод возвращает информацию о пользователе UserInfo
     */
    override fun getUserInfo(): UserInfo {
        TODO("Implementation here")
    }
}
