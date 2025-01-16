package com.prod.core.api.data.sources.remote

import com.prod.core.api.domain.models.UserInfo

/**
 * Интерфейс для получения данных пользователя из API
 */
interface UserRemoteDataSource {

    /**
     * Получить информацию о пользователе
     * @return информация о пользователе
     */
    fun getUserInfo(): UserInfo
}
