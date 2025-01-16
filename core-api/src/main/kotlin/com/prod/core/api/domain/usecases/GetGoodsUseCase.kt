package com.prod.core.api.domain.usecases

import com.prod.core.api.ui.goods.GoodsItemUi

/**
 * Интерфейс UseCase для загрузки элементов витрины товаров
 */
interface GetGoodsUseCase {
    fun getAllGoods(): List<GoodsItemUi>
}
