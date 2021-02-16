package com.hnatiuk.maxim.ui.extensions

import android.widget.ImageView
import coil.load

fun ImageView.loadByUrl(url: String) {
    load(url)
}