package com.prod.solution.impl.ui.banner

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.prod.core.api.ui.banner.BannerUiModel

/**
 * Задача 3. Реализуйте BannerView для показа баннера.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : RelativeLayout(context, attrs, defStyleAttr) {

    /**
     * Метод для инициализации баннера.
     * Принимает состояние экрана и на основе него отрисовывает нужные данные
     * @param model - модель баннера
     */
    fun setupBanner(model: BannerUiModel) {
        TODO("Implementation here")
    }
}
