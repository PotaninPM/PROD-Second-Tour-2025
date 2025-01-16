package com.prod.core.api.mappers

import com.prod.core.api.domain.models.banner.BannerInfo
import com.prod.core.api.ui.banner.BannerUiModel

/**
 * Маппер для преобразования информации о баннере в UI модель
 */
interface BannerInfoToUiModelMapper {

    /**
     * Преобразовать информацию о баннере в UI модель
     * @param bannerInfo информация о баннере
     * @return UI модель баннера
     */
    fun mapBannerInfoToUiModel(bannerInfo: BannerInfo): BannerUiModel
}
