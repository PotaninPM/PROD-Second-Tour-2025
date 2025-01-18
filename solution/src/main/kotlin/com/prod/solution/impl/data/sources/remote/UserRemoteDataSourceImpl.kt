package com.prod.solution.impl.data.sources.remote

import android.util.Log
import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.UserRemoteDataSource
import com.prod.core.api.domain.models.UserInfo
import org.json.JSONException
import org.json.JSONObject

/**
 * Задача 4. Реализуйте сервис для получения данных о пользователе из API
 */
class UserRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : UserRemoteDataSource {

    /**
     * Метод для получения данных о пользователе из API
     * Необходимо получить данные из jsonProvider
     * И вернуть UserInfo
     */
    override fun getUserInfo(): UserInfo {
        val json = jsonProvider.userInfo

        return try {
            val jsonObj = JSONObject(json)

            val lastGoods = jsonObj.getJSONArray("last_goods_cat")
            val availableBonuses = jsonObj.getJSONArray("available_bonuses")
            val favourites = jsonObj.getJSONArray("favourites")
            val activityLevel = jsonObj.getInt("activity_level")

            UserInfo(
                lastGoodsCategories = List(lastGoods.length()) { lastGoods.getString(it) },
                availableBonuses = List(availableBonuses.length()) { availableBonuses.getString(it) },
                favorites = List(favourites.length()) { favourites.getString(it) },
                activityLevel = activityLevel
            )
        } catch (e: JSONException) {
            Log.e("INFOG", "Error", e)
            UserInfo(emptyList(), emptyList(), emptyList(), 0)
        }
    }
}
