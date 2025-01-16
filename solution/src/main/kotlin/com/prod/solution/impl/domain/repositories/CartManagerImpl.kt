package com.prod.solution.impl.domain.repositories

import com.prod.core.api.domain.models.GoodCartInfo
import com.prod.core.api.domain.repositories.CartManager
import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.domain.repositories.UserRepository
import com.prod.core.api.domain.usecases.GetBonusInfoFromGoodInfoUseCase

/**
 * Задача 7. Реализуйте CartManager для расчета всех составляющих экрана корзины.
 */
class CartManagerImpl(
    private val cartRepository: CartRepository,
    private val getBonusInfoFromGoodInfoUseCase: GetBonusInfoFromGoodInfoUseCase,
    private val userRepository: UserRepository,
) : CartManager {

    /*
    * Метод для вычисления полной стоимости корзины
    * Необходимо вернуть сумму всех товаров в корзине
     */
    override fun calculateCosts(): Int {
        TODO("Implementation here")
    }

    /*
    * Метод для вычисления всех бонусов от товаров
    * Необходимо вернуть сумму всех бонусов от товаров
     */
    override fun calculateBonuses(): Int {
        TODO("Implementation here")
    }

    /*
    * Метод для вычисления всех кешбеков от товаров
    * Необходимо вернуть сумму всех кешбеков от товаров
     */
    override fun calculateCashback(): Int {
        TODO("Implementation here")
    }

    /*
    * Метод для вычисления для каждого товара общий вес в граммах/килограммах
    * и общую стоимость n-го числа товаров этого наименования
     */
    override fun calculateGoodsData(): List<GoodCartInfo> {
        TODO("Implementation here")
    }

    /*
    * Метод для вычисления общего веса товаров в килограммах
     */
    override fun calculateAllWeight(): Double {
        TODO("Implementation here")
    }
}
