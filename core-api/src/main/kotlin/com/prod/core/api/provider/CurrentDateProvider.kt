package com.prod.core.api.provider

import java.util.Date

/**
 * Интерфейс для получения текущего значения времени Date
 */
interface CurrentDateProvider {

    /**
     * Метод для получения текущего Date
     * @return объект Date с текущим значением времени
     */
    fun provideCurrentDate(): Date
}
