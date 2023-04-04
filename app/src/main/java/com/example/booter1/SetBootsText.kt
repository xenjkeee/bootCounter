package com.example.booter1

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("bootsText")
fun setBootsText(view: TextView, boots: List<Long>?) = boots?.let {
    view.text = when {
        boots.isEmpty() -> view.context.getString(R.string.no_boots_detected)
        else -> boots.mapIndexed { i, l -> i + 1 to l }
            .joinToString(separator = "\n") { "${it.first} - ${it.second}" }
    }
}