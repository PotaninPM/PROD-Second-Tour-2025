package com.prod.solution.impl.ui.banner

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import com.prod.core.api.ui.banner.BannerUiModel
import com.prod.core.api.ui.banner.LargeBannerUiModel
import com.prod.core.api.ui.banner.SmallBannerUiModel
import com.prod.solution.R
import com.prod.solution.databinding.BannerViewBinding

/**
 * Задача 3. Реализуйте BannerView для показа баннера.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    private var binding: BannerViewBinding = BannerViewBinding.inflate(LayoutInflater.from(context), this, true)

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)

        updateLayoutParams {
            width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    /**
     * Метод для инициализации баннера.
     * Принимает состояние экрана и на основе него отрисовывает нужные данные
     * @param model - модель баннера
     */

    fun setupBanner(model: BannerUiModel) {
        model.smallBanner?.let { small ->
            binding.smallBannerContainer.visibility = View.VISIBLE
            binding.smallBannerRightLabel.text = small.rightLabel
            binding.smallBannerLeftLabel.text = small.leftLabel
            binding.smallBannerImage.setImageResource(small.imageResId)

            if (!small.isFirstInPriority) {
                binding.all.layoutDirection = LAYOUT_DIRECTION_RTL
            }
        }

        Log.i("INFOG", model.smallBanner.toString())

        if (model.smallBanner == null) {
            binding.smallBannerContainer.visibility = GONE
            binding.spacer.visibility = GONE
        } else {
            binding.smallBannerContainer.visibility = VISIBLE
            binding.spacer.visibility = VISIBLE
        }

        model.largeBanner.let { large ->
            binding.largeBannerContainer.visibility = View.VISIBLE
            binding.largeBannerTitle.text = large.title
            binding.largeBannerDescription.text = large.description
            binding.largeBannerImage.setImageResource(large.imageResId)
        }
    }
}
