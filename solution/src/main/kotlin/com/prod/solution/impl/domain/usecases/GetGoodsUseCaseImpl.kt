package com.prod.solution.impl.domain.usecases

import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.domain.repositories.GoodsRepository
import com.prod.core.api.domain.repositories.UserRepository
import com.prod.core.api.domain.usecases.GetBonusInfoFromGoodInfoUseCase
import com.prod.core.api.domain.usecases.GetGoodsUseCase
import com.prod.core.api.mappers.GoodInfoToUiModelMapper
import com.prod.core.api.sorter.GoodsInfoSorter
import com.prod.core.api.ui.goods.GoodsItemUi

/**
 * Задача 5. Реализуйте сервис, который подготавливает данные о всех товарах для отображения
 * в соответствии с условиями задачи.
 */
class GetGoodsUseCaseImpl(
    private val goodsRepository: GoodsRepository,
    private val userRepository: UserRepository,
    private val cartRepository: CartRepository,
    private val getBonusInfoFromGoodInfoUseCase: GetBonusInfoFromGoodInfoUseCase,
    private val goodsInfoSorter: GoodsInfoSorter,
    private val goodInfoToUiModelMapper: GoodInfoToUiModelMapper,
) : GetGoodsUseCase {

    /**
     * Метод возвращает информацию о товарах
     */
    override fun getAllGoods(): List<GoodsItemUi> {
        val goods = goodsRepository.getAllGoods()
        val userInfo = userRepository.getUserInfo()
        val sortedGoods = goodsInfoSorter.sortGoodsInfo(goods, userInfo)

        val cart = cartRepository.getCart()

        return sortedGoods.map { good ->
            val quantity = cart.find { it.first.id == good.id }?.second ?: 0
            val bonusInfo = getBonusInfoFromGoodInfoUseCase.getBonusInfo(good)

            goodInfoToUiModelMapper.mapGoodInfoToUiModel(
                goods = good,
                quantity = quantity,
                userInfo = userInfo,
                bonusInfo = bonusInfo
            )
        }
    }
}
