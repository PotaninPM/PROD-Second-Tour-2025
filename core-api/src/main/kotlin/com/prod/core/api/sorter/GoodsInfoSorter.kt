package com.prod.core.api.sorter

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo

/**
 * Интерфейс сортирвщика товаров в соответствии с предпочтениями пользователя
 */
interface GoodsInfoSorter {

    /**
     * Метод возвращает отсортированную информацию о товарах
     * @param goods исходный список товаров
     * @param userInfo информация о пользователе
     * @return отсортированный список товаров
     */
    fun sortGoodsInfo(goods: List<GoodInfo>, userInfo: UserInfo): List<GoodInfo>
}
