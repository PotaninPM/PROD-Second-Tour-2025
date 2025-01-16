package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.UserInfo

/**
 * Репозиторий для получения информации о пользователе
 */
interface UserRepository {

    /**
     * Получить информацию о пользователе
     * @return информация о пользователе
     */
    fun getUserInfo(): UserInfo
}
