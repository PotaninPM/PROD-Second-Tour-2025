package com.prod.solution.impl.mappers

import com.prod.core.api.domain.models.banner.BannerInfo
import com.prod.core.api.mappers.BannerInfoToUiModelMapper
import com.prod.core.api.ui.banner.BannerUiModel
import com.prod.core.api.ui.banner.LargeBannerUiModel
import com.prod.core.api.ui.banner.SmallBannerUiModel
import com.prod.core.api.ui.extensions.imageIdToResId

/**
 * Задача 2. Реализовать маппер из API модели в модель для UI
 */
class BannerInfoToUiModelMapperImpl : BannerInfoToUiModelMapper {

    /**
     * Метод для маппинга данных баннера из API в модель для UI
     * Необходимо создать BannerUiModel и заполнить его данными из BannerInfo
     * И вернуть BannerUiModel
     */
    override fun mapBannerInfoToUiModel(bannerInfo: BannerInfo): BannerUiModel {
        val largeBanTitle = buildString {
            append(bannerInfo.large.title)
            bannerInfo.large.bonus?.let { bonus ->
                append(" ${bonus.value}${bonus.postfix}")
            }
        }

        val largeBanDesc = bannerInfo.large.description.replace("%s", bannerInfo.large.bonus?.let { "${it.value}${it.postfix}" } ?: "")

        val isLargeFirst = bannerInfo.small == null ||
                bannerInfo.large.priority > bannerInfo.small!!.priority ||
                (bannerInfo.large.priority == bannerInfo.small!!.priority)

        val largeBan = LargeBannerUiModel(
            isFirstInPriority = isLargeFirst,
            title = largeBanTitle,
            description = largeBanDesc,
            imageResId = imageIdToResId(bannerInfo.large.imageId)
        )

        val smallBan = bannerInfo.small?.let { small ->
            SmallBannerUiModel(
                isFirstInPriority = !isLargeFirst,
                rightLabel = small.rightLabel,
                leftLabel = small.leftLabel,
                imageResId = imageIdToResId(small.imageId)
            )
        }

        return BannerUiModel(largeBan, smallBan)
    }
}
