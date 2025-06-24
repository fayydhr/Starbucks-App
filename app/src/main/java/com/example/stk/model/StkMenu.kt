package com.example.stk.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StkMenu(
    @StringRes val nameRes: Int,
    @StringRes val priceRes: Int,
    @DrawableRes val imageRes: Int
)