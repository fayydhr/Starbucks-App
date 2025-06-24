package com.example.stk.data

import com.example.stk.R
import com.example.stk.model.StkMenu

object StkMenuRepository {
    val drinks = listOf(
        StkMenu(
            nameRes = R.string.drink_1_name,
            priceRes = R.string.drink_1_price,
            imageRes = R.drawable.drink_1
        ),
        StkMenu(
            nameRes = R.string.drink_2_name,
            priceRes = R.string.drink_2_price,
            imageRes = R.drawable.drink_2
        ),
        StkMenu(
            nameRes = R.string.drink_3_name,
            priceRes = R.string.drink_3_price,
            imageRes = R.drawable.drink_3
        ),
        StkMenu(
            nameRes = R.string.drink_4_name,
            priceRes = R.string.drink_4_price,
            imageRes = R.drawable.drink_4
        ),
        StkMenu(
            nameRes = R.string.drink_5_name,
            priceRes = R.string.drink_5_price,
            imageRes = R.drawable.drink_5
        ),
        StkMenu(
            nameRes = R.string.drink_6_name,
            priceRes = R.string.drink_6_price,
            imageRes = R.drawable.drink_6
        )
    )
}