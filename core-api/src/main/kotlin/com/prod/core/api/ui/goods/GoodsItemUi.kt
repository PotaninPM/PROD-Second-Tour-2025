package com.prod.core.api.ui.goods

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes

/**
 * UI модель карточки товара
 * @param id идентификатор товара
 * @param name название товара
 * @param imageRes идентификатор ресурса изображения
 * @param producerName производитель
 * @param quantityInfo вес товара
 * @param cost цена
 * @param costAndQuantityInCart количество и цена товара в корзине
 * @param favourite модель для отображения лейбла снизу
 * @param bonus модель для отображения лейбла сверху
 */
data class GoodsItemUi(
    val id: String,
    val name: String,
    @DrawableRes val imageRes: Int,
    val producerName: String,
    val quantityInfo: String,
    val cost: String,
    val costAndQuantityInCart: String? = null,
    val favourite: GoodsFavouriteUi? = null,
    val bonus: GoodsBonusUi? = null,
)

/**
 * UI модель нижнего лейбла
 * @param text текст лейбла
 * @param textColor цвет текста
 */
data class GoodsFavouriteUi(
    val text: String,
    @ColorInt val textColor: Int,
)

/**
 * UI модель верхнего лейбла
 * @param text текст лейбла
 * @param textColor цвет текста
 * @param backgroundColor цвет фона
 * @param borderColor цвет обводки
 */
data class GoodsBonusUi(
    val text: String,
    @ColorInt val textColor: Int,
    @ColorInt val backgroundColor: Int,
    @ColorInt val borderColor: Int? = null,
)
