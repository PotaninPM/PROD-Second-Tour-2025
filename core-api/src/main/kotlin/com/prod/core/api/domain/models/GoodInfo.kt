package com.prod.core.api.domain.models

/**
 * Информация о товаре
 * @param id идентификатор товара
 * @param imageId идентификатор изображения товара
 * @param name название товара
 * @param producer информация о производителе
 * @param isNew признак новинки
 * @param goodItemCountityInfo информация о количестве товара
 * @param cost стоимость товара
 * @param popularity популярность товара
 * @param category категория товара
 * @param rating рейтинг товара
 * @param bonusIds идентификаторы бонусов
 */
data class GoodInfo(
    val id: String,
    val imageId: String,
    val name: String,
    val producer: GoodProducerInfo,
    val isNew: Boolean,
    val goodItemQuantityInfo: GoodItemQuantityInfo,
    val cost: Int,
    val popularity: Int,
    val category: String,
    val bonusIds: List<String> = emptyList(),
    val rating: Double? = null,
)
