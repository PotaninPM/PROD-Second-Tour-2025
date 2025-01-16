package com.prod.core.impl.provider

import com.prod.core.api.provider.CurrentDateProvider
import java.util.Date

internal class CurrentDateProviderImpl : CurrentDateProvider {

    override fun provideCurrentDate(): Date = Date()
}
