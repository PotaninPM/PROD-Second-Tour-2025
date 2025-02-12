package com.prod.solution.impl.ui.banner

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import androidx.core.view.updateLayoutParams
import com.prod.core.api.ui.banner.BannerUiModel
import com.prod.solution.databinding.BannerViewBinding

/**
 * Задача 3. Реализуйте BannerView для показа баннера.
 * Можно использовать любые View и верстать любым способом, в соответствии с макетом.
 */
class BannerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr), ViewTreeObserver.OnGlobalLayoutListener {

    private var binding: BannerViewBinding = BannerViewBinding.inflate(LayoutInflater.from(context), this, true)

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

            if (small.isFirstInPriority) {
                reorder(binding.smallBannerContainer, binding.largeBannerContainer)
            }
        }

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

        viewTreeObserver.addOnGlobalLayoutListener {
            updateLayoutParams {
                width = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
    }

    private fun reorder(first: View, second: View) {
        val parent = first.parent as ViewGroup
        val firstIndex = parent.indexOfChild(first)
        val secondIndex = parent.indexOfChild(second)

        if (firstIndex > secondIndex) {
            parent.removeView(first)
            parent.addView(first, secondIndex)
        }

        updateSpacer(parent, first, second)
    }

    private fun updateSpacer(parent: ViewGroup, first: View, second: View) {
        val spacer = binding.spacer

        val currentParent = spacer.parent as? ViewGroup
        if (currentParent != null && currentParent != parent) {
            currentParent.removeView(spacer)
        }

        val firstIndex = parent.indexOfChild(first)
        val spacerIndex = parent.indexOfChild(spacer)

        if (spacerIndex != firstIndex + 1) {
            parent.removeView(spacer)
            parent.addView(spacer, firstIndex + 1)
        }
    }

    override fun onGlobalLayout() {

    }
}

