package com.prod.core.api.ui.extensions

import com.prod.core.api.R

/**
 * Преобразовать идентификатор изображения в идентификатор ресурса.
 * Если идентификатор не найден, возвращает 0
 * @param imageId идентификатор изображения
 * @return идентификатор ресурса
 */
fun imageIdToResId(imageId: String): Int {
    return when (imageId) {
        "banner-1-img" -> R.drawable.banner_1_img
        "bonus-badge" -> R.drawable.bonus_badge
        "goods-1-img" -> R.drawable.goods_1_img
        "goods-2-img" -> R.drawable.goods_2_img
        "goods-3-img" -> R.drawable.goods_3_img
        "goods-4-img" -> R.drawable.goods_4_img
        "goods-placeholder" -> R.drawable.goods_placeholder
        else -> 0
    }
}
