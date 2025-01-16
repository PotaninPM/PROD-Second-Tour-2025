package com.prod.core.api.domain.models

/**
 * Информация о производителе товара
 * @param id идентификатор производителя
 * @param name название производителя
 */
data class GoodProducerInfo(
    val id: String,
    val name: String,
)
