package com.example.stk.data

import com.example.stk.R // Corrected import
import com.example.stk.model.StkReward

object StkRewardRepository {
    val rewards = listOf(
        StkReward(
            titleRes = R.string.reward_1_title,
            descriptionRes = R.string.reward_1_description,
            imageRes = R.drawable.drink_2
        ),
        StkReward(
            titleRes = R.string.reward_2_title,
            descriptionRes = R.string.reward_2_description,
            imageRes = R.drawable.drink_6
        ),
        StkReward(
            titleRes = R.string.reward_3_title,
            descriptionRes = R.string.reward_3_description,
            imageRes = R.drawable.drink_4
        ),
    )
}