package com.hnatiuk.maxim.ui.binding

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun setVisibility(view: View, isVisible: Boolean?) {
    view.isVisible = isVisible ?: false
}
