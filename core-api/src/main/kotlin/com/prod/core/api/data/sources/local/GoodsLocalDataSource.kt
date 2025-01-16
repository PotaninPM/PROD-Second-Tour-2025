package com.prod.core.api.data.sources.local

import com.prod.core.api.domain.models.GoodInfo

/**
 * Интерфейс для работы с локальным источником данных по товарам
 * Имитирует работу с базой данных
 */
interface GoodsLocalDataSource {

    /**
     * Кешировать товары
     * @param goods список товаров
     */
    fun cacheGoods(goods: List<GoodInfo>)

    /**
     * Получить закешированные товары
     * @return список товаров
     */
    fun getCachedGoods(): List<GoodInfo>
}
