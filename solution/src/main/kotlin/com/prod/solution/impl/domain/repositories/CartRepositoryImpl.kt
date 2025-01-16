package com.prod.solution.impl.domain.repositories

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.CartRepository

/**
 * Задача 8. Реализуйте репозиторий добавления и удаления в корзину.
 */
class CartRepositoryImpl : CartRepository {

    /*
     * Метод для возврата всей корзины
     * Необходимо вернуть список пар, где первый элемент - информация о товаре, второй - количество
     */
    override fun getCart(): List<Pair<GoodInfo, Int>> {
        TODO("Implementation here")
    }

    /*
    * Метод для увеличения количества товара в корзине
    * Добавление новых наименований происходит в конец корзины
    * Необходимо увеличить количество товара в корзине на один
     */
    override fun increaseGoodQuantity(good: GoodInfo) {
        TODO("Implementation here")
    }

    /*
    * Метод для уменьшения количества товара в корзине
    * Необходимо уменьшить количество товара в корзине на один
     */
    override fun decreaseGoodQuantity(good: GoodInfo) {
        TODO("Implementation here")
    }

    /*
    * Метод для удаления всех количеств товара из корзины
    * Необходимо удалить все количества товара из корзины
     */
    override fun deleteAllQuantitiesFromCart(good: GoodInfo) {
        TODO("Implementation here")
    }
}
