package com.prod.solution.impl.domain.usecases

import com.prod.core.api.domain.models.BonusInfo
import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.BonusesRepository
import com.prod.core.api.domain.repositories.UserRepository
import com.prod.core.api.domain.usecases.GetBonusInfoFromGoodInfoUseCase
import com.prod.core.api.provider.CurrentDateProvider

/**
 * Задача 5. Реализуйте логику подбора бонуса для конкретного товара
 */
class GetBonusInfoFromGoodInfoUseCaseImpl(
    private val bonusesRepository: BonusesRepository,
    private val userRepository: UserRepository,
    private val currentDateProvider: CurrentDateProvider,
) : GetBonusInfoFromGoodInfoUseCase {

    /**
     * Метод принимает товар и возвращает бонус согласно задаче
     */
    override fun getBonusInfo(goodInfo: GoodInfo): BonusInfo? {
        TODO("Implementation here")
    }
}
