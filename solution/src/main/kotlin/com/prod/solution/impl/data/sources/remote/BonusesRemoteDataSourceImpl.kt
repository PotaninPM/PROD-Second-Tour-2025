package com.prod.solution.impl.data.sources.remote

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.BonusesRemoteDataSource
import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.PromotionExtra
import org.json.JSONArray
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Задача 4. Реализуйте сервис для получения данных о бонусах из API
 */
class BonusesRemoteDataSourceImpl(
    private val jsonProvider: JsonProvider,
) : BonusesRemoteDataSource {

    /**
     * Метод для получения данных о бонусах из API
     * Необходимо получить данные из jsonProvider
     * И вернуть List<BonusInfo>
     */
    override fun getAllBonuses(): List<BonusInfo> {
        val json = jsonProvider.allBonusesJson
        val jsonArray = JSONArray(json)
        val bonuses = mutableListOf<BonusInfo>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val bonus = parseBonus(jsonObject)
            bonuses.add(bonus)
        }

        return bonuses
    }

    private fun parseBonus(jsonObject: JSONObject): BonusInfo {
        val id = jsonObject.getString("id")
        val type = jsonObject.getString("type")
        val value = jsonObject.getDouble("value")

        var bonusInfo = BonusInfo(id, type, value)

        if (jsonObject.has("available_due_to")) {
            val dateString = jsonObject.getString("available_due_to")
            val avDueTo = parseDate(dateString)
            bonusInfo = bonusInfo.copy(availableDueTo = avDueTo)
        }
        if (jsonObject.has("promotion_extra")) {
            val promotionExtra = jsonObject.getJSONObject("promotion_extra")
            val promotion = PromotionExtra(
                baseColor = promotionExtra.getString("base_color"),
                tintColor = promotionExtra.getString("tint_color"),
                label = promotionExtra.getString("label")
            )
            bonusInfo = bonusInfo.copy(promotionExtra = promotion)
        }

        return bonusInfo
    }

    private fun parseDate(dateString: String): Date? {
        return try {
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            format.parse(dateString)
        } catch (e: Exception) {
            null
        }
    }
}
