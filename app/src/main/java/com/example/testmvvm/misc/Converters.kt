package com.example.testmvvm.misc

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion

object Converters {

    @JvmStatic
    @BindingAdapter("android:text")
    fun adaptIntToString(view: TextView, intVal: Int) {
        view.text = intVal.toString()
    }

}