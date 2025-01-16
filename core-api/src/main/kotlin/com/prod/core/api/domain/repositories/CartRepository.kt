package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.GoodInfo

/**
 * Репозиторий для работы с корзиной
 */
interface CartRepository {

    /**
     * Получить корзину
     * @return список товаров и их количества
     */
    fun getCart(): List<Pair<GoodInfo, Int>>

    /**
     * Увеличить количество товара в корзине
     * @param good товар
     */
    fun increaseGoodQuantity(good: GoodInfo)

    /**
     * Уменьшить количество товара в корзине
     * @param good товар
     */
    fun decreaseGoodQuantity(good: GoodInfo)

    /**
     * Удалить товар из корзины
     * @param good товар
     */
    fun deleteAllQuantitiesFromCart(good: GoodInfo)
}
