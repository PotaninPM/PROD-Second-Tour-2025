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
        val userBon = userRepository.getUserInfo().availableBonuses
        val allBonuses = bonusesRepository.getAllBonuses()

        val activeBon = allBonuses.filter { bonus ->
            bonus.availableDueTo?.after(currentDateProvider.provideCurrentDate()) ?: true
        }

        return goodInfo.bonusIds.firstOrNull { bonusId ->
            activeBon.any { bonus ->
                bonus.id == bonusId && userBon.contains(bonusId)
            }
        }?.let { bonusId ->
            activeBon.find { it.id == bonusId }
        }
    }
}
