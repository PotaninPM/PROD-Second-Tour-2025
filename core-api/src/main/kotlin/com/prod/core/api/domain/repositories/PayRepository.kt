package com.prod.core.api.domain.repositories

import com.prod.core.api.domain.models.GoodInfo

/**
 * Репозиторий для оплаты товаров
 */
interface PayRepository {

    /**
     * Оплатить товары
     * @param cardNumber номер карты
     * @param cardDate дата карты
     * @param cardCvv cvv карты
     * @param goodsList список товаров и их количества
     */
    fun pay(
        cardNumber: String,
        cardDate: String,
        cardCvv: String,
        goodsList: List<Pair<GoodInfo, Int>>
    )
}
