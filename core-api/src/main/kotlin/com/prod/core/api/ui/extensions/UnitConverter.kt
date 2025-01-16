package com.prod.core.api.ui.extensions

import android.content.Context
import android.content.res.Resources
import androidx.annotation.Px
import kotlin.math.roundToInt

fun Context.spToPx(sp: Float): Float {
    val scale = resources.displayMetrics.scaledDensity
    return sp * scale
}

@Px
fun Context.dpToPx(dp: Float): Int {
    return dpToPx(dp, resources)
}

@Px
fun dpToPx(dp: Float, resources: Resources): Int {
    return dpToPxAsFloat(dp, resources).roundToInt()
}

@Px
fun dpToPxAsFloat(dp: Float, resources: Resources): Float {
    return dp * resources.displayMetrics.density
}