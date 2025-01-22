package com.prod.solution.impl.domain.repositories

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.CartRepository

/**
 * Задача 8. Реализуйте репозиторий добавления и удаления в корзину.
 */
class CartRepositoryImpl : CartRepository {

    private val cartMap = mutableMapOf<GoodInfo, Int>()

    /*
     * Метод для возврата всей корзины
     * Необходимо вернуть список пар, где первый элемент - информация о товаре, второй - количество
     */
    override fun getCart(): List<Pair<GoodInfo, Int>> {
        return cartMap.toList()
    }

    /*
    * Метод для увеличения количества товара в корзине
    * Добавление новых наименований происходит в конец корзины
    * Необходимо увеличить количество товара в корзине на один
     */
    override fun increaseGoodQuantity(good: GoodInfo) {
        cartMap[good] = (cartMap[good] ?: 0) + 1
    }

    /*
    * Метод для уменьшения количества товара в корзине
    * Необходимо уменьшить количество товара в корзине на один
     */
    override fun decreaseGoodQuantity(good: GoodInfo) {
        val new = (cartMap[good] ?: 0) - 1
        if (new > 0) {
            cartMap[good] = new
        } else {
            cartMap.remove(good)
        }
    }

    /*
    * Метод для удаления всех количеств товара из корзины
    * Необходимо удалить все количества товара из корзины
     */
    override fun deleteAllQuantitiesFromCart(good: GoodInfo) {
        cartMap.remove(good)
    }
}
