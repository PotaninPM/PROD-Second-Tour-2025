package com.prod.solution.impl.data.sources.remote

import android.util.Log
import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.remote.BannerRemoteDataSource
import com.prod.core.api.domain.models.banner.BannerInfo
import com.prod.core.api.domain.models.banner.LargeBannerInfo
import com.prod.core.api.domain.models.banner.SmallBannerInfo
import com.prod.core.api.ui.banner.BannerUiModel
import org.json.JSONObject

/**
 * Задача 1. Реализуйте сервис для получения данных баннера из API
 */
class BannerRemoteDataSourceImpl(private val jsonProvider: JsonProvider) : BannerRemoteDataSource {

    /**
     * Метод для получения данных баннера из API
     * Необходимо получить данные из jsonProvider
     * И вернуть BannerInfo
     */

    override fun getBanner(): BannerInfo {
        val json = jsonProvider.bannerInfoJson
        val jsonObj = JSONObject(json)

        val bigJs = jsonObj.getJSONObject("large")

        val largeBan = LargeBannerInfo(
            priority = bigJs.getInt("priority"),
            imageId = bigJs.getString("image_id"),
            title = bigJs.getString("title"),
            description = bigJs.getString("description"),
            bonus = bigJs.optJSONObject("bonus")?.let { bonusJson ->
                LargeBannerInfo.LargeBannerBonus(
                    value = bonusJson.getInt("value"),
                    postfix = bonusJson.getString("postfix")
                )
            }
        )

        val smallBan = jsonObj.optJSONObject("small")?.let { smallJson ->
            SmallBannerInfo(
                priority = smallJson.getInt("priority"),
                rightLabel = smallJson.getString("right_label"),
                leftLabel = smallJson.getString("left_label"),
                imageId = smallJson.getString("image_id")
            )
        }

        return BannerInfo(largeBan, smallBan)
    }
}
