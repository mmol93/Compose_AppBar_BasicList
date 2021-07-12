package com.example.composetheme.ui.theme.AppBar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.composetheme.R

sealed class AppBarData(@StringRes val label : Int, @DrawableRes val icon : Int) {
    object Action1 : AppBarData(R.string.action1, R.drawable.ic_baseline_settings_24)
    object Action2 : AppBarData(R.string.action2, R.drawable.ic_baseline_search_24)
}