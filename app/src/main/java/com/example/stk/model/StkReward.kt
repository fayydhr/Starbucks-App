package com.example.stk.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StkReward(
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int
)