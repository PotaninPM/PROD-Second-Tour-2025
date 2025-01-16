package com.prod.solution.impl.mappers

import com.prod.core.api.domain.models.banner.BannerInfo
import com.prod.core.api.mappers.BannerInfoToUiModelMapper
import com.prod.core.api.ui.banner.BannerUiModel

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
        TODO("Implementation here")
    }
}
