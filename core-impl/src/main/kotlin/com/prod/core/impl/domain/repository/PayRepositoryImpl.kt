package com.prod.core.impl.domain.repository

import com.prod.core.api.domain.models.GoodInfo
import com.prod.core.api.domain.repositories.PayRepository

internal class PayRepositoryImpl : PayRepository {
    override fun pay(
        cardNumber: String,
        cardDate: String,
        cardCvv: String,
        goodsList: List<Pair<GoodInfo, Int>>
    ) {
        // Do payment
    }
}
