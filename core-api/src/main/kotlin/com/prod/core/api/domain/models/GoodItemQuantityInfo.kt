package com.prod.core.api.domain.models

/**
 * Информация о количестве товаров
 * @param type тип товара
 * @param value количество товаров
 */
data class GoodItemQuantityInfo(
    val type: String,
    val value: Int,
)
