package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.GoodsRemoteDataSource
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.models.GoodItemQuantityInfo
import com.prod.core.api.domain.models.GoodProducerInfo
import org.json.JSONObject
import kotlin.math.round

/**
 * Задача 4. Реализуйте сервис для получения данных о товарах из API
 */
class GoodsRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : GoodsRemoteDataSource {

    /**
     * Метод для получения данных о товарах из API
     * Необходимо получить данные из jsonProvider
     * И вернуть List<GoodInfo>
     */
    override fun getAllGoods(): List<GoodInfo> {
        val json = jsonProvider.allGoodsJson
        val jsonObject = JSONObject(json)
        val goodsArray = jsonObject.getJSONArray("goods")
        val goods = mutableListOf<GoodInfo>()

        for (i in 0 until goodsArray.length()) {
            val goodObject = goodsArray.getJSONObject(i)
            val goodInfo = parseGood(goodObject)
            goods.add(goodInfo)
        }

        return goods
    }

    private fun parseGood(goodObject: JSONObject): GoodInfo {
        val id = goodObject.getString("id")
        val imageId = goodObject.getString("image_id")
        val name = goodObject.getString("name")

        val producerObject = goodObject.getJSONObject("producer")
        val producer = GoodProducerInfo(
            id = producerObject.getString("id"),
            name = producerObject.getString("name")
        )

        val isNew = if (goodObject.has("is_new")) {
            goodObject.getBoolean("is_new")
        } else {
            false
        }

        val itemQuantityObject = goodObject.getJSONObject("item_countity")
        val goodItemQuantityInfo = GoodItemQuantityInfo(
            type = itemQuantityObject.getString("type"),
            value = itemQuantityObject.getInt("value")
        )

        val cost = goodObject.getDouble("cost").toInt()
        val popularity = goodObject.getInt("popularity")
        val category = goodObject.getString("category")

        val bonusIds = if (goodObject.has("bonus_ids")) {
            val bonusIdsArray = goodObject.getJSONArray("bonus_ids")
            List(bonusIdsArray.length()) { bonusIdsArray.getString(it) }
        } else {
            emptyList()
        }

        val rating = if (goodObject.has("rating")) {
            goodObject.getDouble("rating")
        } else {
            null
        }

        return GoodInfo(
            id = id,
            imageId = imageId,
            name = name,
            producer = producer,
            isNew = isNew,
            goodItemQuantityInfo = goodItemQuantityInfo,
            cost = cost,
            popularity = popularity,
            category = category,
            bonusIds = bonusIds,
            rating = rating
        )
    }
}
