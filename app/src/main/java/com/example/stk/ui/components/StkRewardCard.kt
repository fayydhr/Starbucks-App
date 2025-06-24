package com.example.stk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stk.ui.theme.StkTheme // Corrected import
import com.example.stk.data.StkRewardRepository
import com.example.stk.model.StkReward
import com.example.stk.R // Added import for R

@Composable
fun StkRewardCard(reward: StkReward, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.weight(2f)
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = stringResource(id = reward.titleRes),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = reward.descriptionRes),
                    textAlign = TextAlign.Justify,
                    fontSize = 14.sp,
                    lineHeight = 20.sp
                )
            }
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(id = reward.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                )
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun StkRewardCardPreview() {
    val rewards = StkRewardRepository.rewards
    StkTheme {
        StkRewardCard(rewards[0])
    }
}