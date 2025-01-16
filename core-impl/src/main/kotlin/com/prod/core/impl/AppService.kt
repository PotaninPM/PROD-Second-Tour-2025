package com.prod.core.impl

import com.prod.core.api.data.json.JsonProvider
import com.prod.core.api.data.sources.local.BonusesLocalDataSource
import com.prod.core.api.data.sources.local.GoodsLocalDataSource
import com.prod.core.api.data.sources.remote.BannerRemoteDataSource
import com.prod.core.api.data.sources.remote.BonusesRemoteDataSource
import com.prod.core.api.data.sources.remote.GoodsRemoteDataSource
import com.prod.core.api.data.sources.remote.UserRemoteDataSource
import com.prod.core.api.domain.repositories.BannerRepository
import com.prod.core.api.domain.repositories.BonusesRepository
import com.prod.core.api.domain.repositories.CartManager
import com.prod.core.api.domain.repositories.CartRepository
import com.prod.core.api.domain.repositories.GoodsRepository
import com.prod.core.api.domain.repositories.PayRepository
import com.prod.core.api.domain.repositories.UserRepository
import com.prod.core.api.domain.usecases.GetBonusInfoFromGoodInfoUseCase
import com.prod.core.api.domain.usecases.GetGoodsUseCase
import com.prod.core.api.domain.usecases.PayUseCase
import com.prod.core.api.domain.usecases.PaymentCardValidateUseCase
import com.prod.core.api.mappers.BannerInfoToUiModelMapper

internal interface AppService {
    val jsonProvider: JsonProvider

    val goodsLocalDataSource: GoodsLocalDataSource
    val goodsRemoteDataSource: GoodsRemoteDataSource
    val goodsRepository: GoodsRepository
    val getGoodsUseCase: GetGoodsUseCase

    val bonusesLocalDataSource: BonusesLocalDataSource
    val bonusesRemoteDataSource: BonusesRemoteDataSource
    val bonusesRepository: BonusesRepository
    val getBonusInfoFromGoodInfoUseCase: GetBonusInfoFromGoodInfoUseCase

    val userRemoteDataSource: UserRemoteDataSource
    val userRepository: UserRepository

    val cartRepository: CartRepository
    val cartManager: CartManager

    val bannerRemoteDataSource: BannerRemoteDataSource
    val bannerRepository: BannerRepository
    val bannerInfoToUiModelMapper: BannerInfoToUiModelMapper

    val payRepository: PayRepository
    val paymentCardValidateUseCase: PaymentCardValidateUseCase
    val payUseCase: PayUseCase
}

internal object AppServiceHolder {
    val appService: AppService = AppServiceSolution
}
