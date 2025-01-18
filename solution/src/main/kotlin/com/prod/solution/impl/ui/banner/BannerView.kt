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

    /**
     * Метод для инициализации баннера.
     * Принимает состояние экрана и на основе него отрисовывает нужные данные
     * @param model - модель баннера
     */
    fun setupBanner(model: BannerUiModel) {
        val small = model.smallBanner
        val large = model.largeBanner

        if (small != null) {
            if (large.isFirstInPriority) {
                showLarge(large)
                showSmall(small)
                reorder(binding.largeBannerContainer, binding.smallBannerContainer)
                setMargins(binding.largeBannerContainer, binding.smallBannerContainer)
            } else {
                showSmall(small)
                showLarge(large)
                reorder(binding.smallBannerContainer, binding.largeBannerContainer)
                setMargins(binding.smallBannerContainer, binding.largeBannerContainer)
            }
        } else {
            showLarge(large)
            binding.largeBannerContainer.visibility = View.VISIBLE
            binding.smallBannerContainer.visibility = View.GONE
            resetMargins(binding.largeBannerContainer)
        }
    }

    private fun showSmall(small: SmallBannerUiModel) {
        binding.smallBannerContainer.visibility = View.VISIBLE
        binding.smallBannerRightLabel.text = small.rightLabel
        binding.smallBannerLeftLabel.text = small.leftLabel
        binding.smallBannerImage.setImageResource(small.imageResId)
    }

    private fun showLarge(large: LargeBannerUiModel) {
        binding.largeBannerContainer.visibility = View.VISIBLE
        binding.largeBannerTitle.text = large.title
        binding.largeBannerDescription.text = large.description
        binding.largeBannerImage.setImageResource(large.imageResId)
    }

    private fun setMargins(first: View, second: View) {
        val paramsFirst = first.layoutParams as MarginLayoutParams
        val paramsSecond = second.layoutParams as MarginLayoutParams

        paramsFirst.setMargins(0, 0, dpToPx(8), 0)

        first.layoutParams = paramsFirst
        second.layoutParams = paramsSecond
    }

    private fun reorder(first: View, second: View) {
        val parent = first.parent as ViewGroup
        val firstIndex = parent.indexOfChild(first)
        val secondIndex = parent.indexOfChild(second)

        if (firstIndex > secondIndex) {
            parent.removeView(first)
            parent.addView(first, secondIndex)
        }
    }

    private fun resetMargins(view: View) {
        val params = view.layoutParams as MarginLayoutParams
        params.setMargins(0, 0, 0, 0)
        view.layoutParams = params
    }

    private fun dpToPx(dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}
