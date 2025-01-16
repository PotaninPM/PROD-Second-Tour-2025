package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.GoodInfo

/**
 * Репозиторий для работы с товарами
 */
interface GoodsRepository {

    /**
     * Получить информацию о всех товарах
     * @return список товаров
     */
    fun getAllGoods(): List<GoodInfo>
}
