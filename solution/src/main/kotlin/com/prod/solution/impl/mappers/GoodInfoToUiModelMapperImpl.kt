package com.prod.solution.impl.mappers

import android.graphics.Color
import com.prod.core.api.Const
import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.UserInfo
import com.prod.core.api.mappers.GoodInfoToUiModelMapper
import com.prod.core.api.ui.extensions.imageIdToResId
import com.prod.core.api.ui.goods.GoodsBonusUi
import com.prod.core.api.ui.goods.GoodsFavouriteUi
import com.prod.core.api.ui.goods.GoodsItemUi
import java.text.NumberFormat
import java.util.Locale

/**
 * Задача 5. Реализуйте маппер, который превращает сырые данные в данные, готовые для показа на экране
 */
class GoodInfoToUiModelMapperImpl : GoodInfoToUiModelMapper {

    /**
     * Метод возвращает информацию о товаре в соответствии с задачей
     */
    override fun mapGoodInfoToUiModel(
        goods: GoodInfo,
        quantity: Int,
        userInfo: UserInfo,
        bonusInfo: BonusInfo?,
    ): GoodsItemUi {
        val imageResId = imageIdToResId(goods.imageId)

        val weight = "${goods.goodItemQuantityInfo.value} ${
            when (goods.goodItemQuantityInfo.type) {
                Const.TYPE_KILO -> "кг"
                Const.TYPE_GRAMM -> "г"
                else -> ""
            }
        }"

        val price = "${goods.cost} ${Const.RUBBLE}"

        val btnText = if (quantity > 0) {
            val totCost = goods.cost * quantity
            val formCost = NumberFormat.getNumberInstance(Locale("ru")).format(totCost)

            "${quantity}шт. = $formCost ${Const.RUBBLE}"

        } else {
            null
        }

        val label = when {
            userInfo.favorites.contains(goods.id) -> GoodsFavouriteUi(
                text = Const.FAVOURITE,
                textColor = Color.BLACK
            )
            goods.isNew -> GoodsFavouriteUi(
                text = Const.NEW,
                textColor = Color.parseColor("#F8AA1B")
            )
            else -> null
        }

        val bonusInfo = bonusInfo?.let { bonus ->
            val labelText = when (bonus.type) {
                Const.TYPE_CASHBACK -> if (bonus.promotionExtra != null) {
                    "${bonus.promotionExtra!!.label} • ${bonus.value}%"
                } else {
                    "Кэшбэк ${(bonus.value * 100).toInt()}%"
                }

                Const.TYPE_POINTS -> if (bonus.promotionExtra != null) {
                    "${bonus.promotionExtra!!.label} • ${bonus.value.toInt()} Б"
                } else {
                    "${bonus.value.toInt()} баллов"
                }

                else -> "${bonus.value.toInt()} баллов"
            }

            GoodsBonusUi(
                text = labelText,
                textColor = bonus.promotionExtra?.tintColor?.let { color ->
                    Color.parseColor(if (!color.startsWith("#")) "#$color" else color)
                } ?: Color.BLACK,
                backgroundColor = bonus.promotionExtra?.baseColor?.let { color ->
                    Color.parseColor(if (!color.startsWith("#")) "#$color" else color)
                } ?: Color.WHITE,
                borderColor = if (bonus.promotionExtra != null) {
                    Color.parseColor("#000000")
                } else {
                    null
                }
            )

        }

        return GoodsItemUi(
            id = goods.id,
            name = goods.name,
            imageRes = imageResId,
            producerName = goods.producer.name,
            quantityInfo = weight,
            cost = price,
            costAndQuantityInCart = btnText,
            favourite = label,
            bonus = bonusInfo
        )
    }
}
