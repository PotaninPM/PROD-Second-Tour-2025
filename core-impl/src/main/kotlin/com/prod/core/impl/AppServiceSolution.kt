package com.prod.core.impl

import com.prod.core.api.domain.repositories.GoodsRepository
import com.prod.core.api.domain.repositories.UserRepository
import com.prod.core.api.domain.usecases.GetBonusInfoFromGoodInfoUseCase
import com.prod.core.api.domain.usecases.GetGoodsUseCase
import com.prod.core.api.mappers.GoodInfoToUiModelMapper
import com.prod.core.api.provider.CurrentDateProvider
import com.prod.core.api.sorter.GoodsInfoSorter
import com.prod.core.api.sorter.GoodsScoreCalculator
import com.prod.core.impl.data.json.DefaultJsonProvider
import com.prod.core.impl.domain.repository.PayRepositoryImpl
import com.prod.core.impl.provider.CurrentDateProviderImpl
import com.prod.solution.impl.data.sources.local.BonusesLocalDataSourceImpl
import com.prod.solution.impl.data.sources.local.GoodsLocalDataSourceImpl
import com.prod.solution.impl.data.sources.remote.BannerRemoteDataSourceImpl
import com.prod.solution.impl.data.sources.remote.BonusesRemoteDataSourceImpl
import com.prod.solution.impl.data.sources.remote.GoodsRemoteDataSourceImpl
import com.prod.solution.impl.data.sources.remote.UserRemoteDataSourceImpl
import com.prod.solution.impl.domain.repositories.BannerRepositoryImpl
import com.prod.solution.impl.domain.repositories.BonusesRepositoryImpl
import com.prod.solution.impl.domain.repositories.CartManagerImpl
import com.prod.solution.impl.domain.repositories.CartRepositoryImpl
import com.prod.solution.impl.domain.repositories.GoodsRepositoryImpl
import com.prod.solution.impl.domain.repositories.UserRepositoryImpl
import com.prod.solution.impl.domain.usecases.GetBonusInfoFromGoodInfoUseCaseImpl
import com.prod.solution.impl.domain.usecases.GetGoodsUseCaseImpl
import com.prod.solution.impl.domain.usecases.PayUseCaseImpl
import com.prod.solution.impl.domain.usecases.PaymentCardValidateUseCaseImpl
import com.prod.solution.impl.mappers.BannerInfoToUiModelMapperImpl
import com.prod.solution.impl.mappers.GoodInfoToUiModelMapperImpl
import com.prod.solution.impl.sorter.GoodsInfoSorterImpl
import com.prod.solution.impl.sorter.GoodsScoreCalculatorImpl

internal object AppServiceSolution : AppService {

    override val jsonProvider = DefaultJsonProvider()

    override val goodsLocalDataSource = GoodsLocalDataSourceImpl()
    override val goodsRemoteDataSource = GoodsRemoteDataSourceImpl(jsonProvider = jsonProvider)
    override val goodsRepository: GoodsRepository = GoodsRepositoryImpl(
        goodsLocalDataSource = goodsLocalDataSource,
        goodsRemoteDataSource = goodsRemoteDataSource,
    )

    override val bonusesLocalDataSource = BonusesLocalDataSourceImpl()
    override val bonusesRemoteDataSource = BonusesRemoteDataSourceImpl(jsonProvider = jsonProvider)
    override val bonusesRepository = BonusesRepositoryImpl(
        bonusesLocalDataSource = bonusesLocalDataSource,
        bonusesRemoteDataSource = bonusesRemoteDataSource
    )
    override val userRemoteDataSource = UserRemoteDataSourceImpl(jsonProvider = jsonProvider)
    override val userRepository: UserRepository = UserRepositoryImpl(userRemoteDataSource)

    override val cartRepository = CartRepositoryImpl()

    private val currentDateProvider: CurrentDateProvider = CurrentDateProviderImpl()
    private val goodsScoreCalculator: GoodsScoreCalculator = GoodsScoreCalculatorImpl()
    private val goodsInfoSorter: GoodsInfoSorter = GoodsInfoSorterImpl(goodsScoreCalculator)
    private val goodInfoToUiModelMapper: GoodInfoToUiModelMapper = GoodInfoToUiModelMapperImpl()
    override val getBonusInfoFromGoodInfoUseCase: GetBonusInfoFromGoodInfoUseCase =
        GetBonusInfoFromGoodInfoUseCaseImpl(
            bonusesRepository = bonusesRepository,
            userRepository = userRepository,
            currentDateProvider = currentDateProvider,
        )
    override val getGoodsUseCase: GetGoodsUseCase = GetGoodsUseCaseImpl(
        goodsRepository = goodsRepository,
        userRepository = userRepository,
        cartRepository = cartRepository,
        getBonusInfoFromGoodInfoUseCase = getBonusInfoFromGoodInfoUseCase,
        goodsInfoSorter = goodsInfoSorter,
        goodInfoToUiModelMapper = goodInfoToUiModelMapper,
    )

    override val cartManager = CartManagerImpl(
        cartRepository = cartRepository,
        getBonusInfoFromGoodInfoUseCase = getBonusInfoFromGoodInfoUseCase,
        userRepository = userRepository
    )

    override val bannerRemoteDataSource = BannerRemoteDataSourceImpl(jsonProvider = jsonProvider)
    override val bannerRepository = BannerRepositoryImpl(remoteDataSource = bannerRemoteDataSource)
    override val bannerInfoToUiModelMapper = BannerInfoToUiModelMapperImpl()

    override val payRepository = PayRepositoryImpl()
    override val paymentCardValidateUseCase = PaymentCardValidateUseCaseImpl()
    override val payUseCase = PayUseCaseImpl(
        payRepository = payRepository,
        cartRepository = cartRepository,
    )
}
