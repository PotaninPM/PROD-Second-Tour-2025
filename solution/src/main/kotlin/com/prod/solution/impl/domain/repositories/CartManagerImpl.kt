package com.prod.solution.impl.domain.repositories

import com.prod.core.api.Const
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
        val cart = cartRepository.getCart()
        return cart.sumOf { (good, quantity) ->
            good.cost * quantity
        }
    }

    /*
    * Метод для вычисления всех бонусов от товаров
    * Необходимо вернуть сумму всех бонусов от товаров
     */
    override fun calculateBonuses(): Int {
        val cartItems = cartRepository.getCart()
        val userInfo = userRepository.getUserInfo()

        return cartItems.sumOf { (good, quantity) ->
            val bonus = getBonusInfoFromGoodInfoUseCase.getBonusInfo(good)

            if (bonus != null) {
                val isFav = userInfo.favorites.contains(good.id)
                val baseBonus = (bonus.value * quantity).toInt()

                if (isFav) {
                    (baseBonus * 1.2).toInt()
                } else {
                    baseBonus
                }
            } else 0
        }
    }

    /*
    * Метод для вычисления всех кешбеков от товаров
    * Необходимо вернуть сумму всех кешбеков от товаров
     */
    override fun calculateCashback(): Int {
        val cartItems = cartRepository.getCart()
        val userInfo = userRepository.getUserInfo()
        val activLevel = userInfo.activityLevel

        val extraCash = when (activLevel) {
            in 0..25 -> 0
            in 26..50 -> 2
            in 51..75 -> 3
            in 76..100 -> 5
            else -> 0
        }

        return cartItems.sumOf { (good, quantity) ->
            val bonusInfo = getBonusInfoFromGoodInfoUseCase.getBonusInfo(good)
            if (bonusInfo != null) {
                val baseCash = (bonusInfo.value * quantity).toInt()
                baseCash +  (baseCash * extraCash / 100)
            } else 0
        }
    }

    /*
    * Метод для вычисления для каждого товара общий вес в граммах/килограммах
    * и общую стоимость n-го числа товаров этого наименования
     */
    override fun calculateGoodsData(): List<GoodCartInfo> {
        val cartItems = cartRepository.getCart()

        return cartItems.map { (good, quantity) ->
            val weight = when (good.goodItemQuantityInfo.type) {
                Const.TYPE_GRAMM -> good.goodItemQuantityInfo.value
                Const.TYPE_KILO -> good.goodItemQuantityInfo.value * 1000
                else -> 0
            } * quantity

            val cost = good.cost * quantity

            GoodCartInfo(
                totalCost = cost,
                countInCart = quantity,
                quantityValue = weight,
                goodInfo = good
            )
        }
    }

    /*
    * Метод для вычисления общего веса товаров в килограммах
     */
    override fun calculateAllWeight(): Double {
        val cartItems = cartRepository.getCart()

        val weight = cartItems.sumOf { (good, quantity) ->
            when (good.goodItemQuantityInfo.type) {
                Const.TYPE_GRAMM -> good.goodItemQuantityInfo.value
                Const.TYPE_KILO -> good.goodItemQuantityInfo.value * 1000
                else -> 0
            } * quantity
        }

        return weight / 1000.0
    }
}
