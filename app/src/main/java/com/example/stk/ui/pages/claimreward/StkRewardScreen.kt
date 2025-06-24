package com.example.stk.ui.pages.claimreward

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme // Added import
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stk.ui.theme.StkTheme
import com.example.stk.R
import com.example.stk.data.StkRewardRepository
import com.example.stk.ui.components.StkBottomNavigationBar
import com.example.stk.ui.components.StkRewardCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun StkRewardActivity(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            StkBottomNavigationBar(navController = navHostController )
        }
    ) { innerPadding ->
        RewardScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun RewardScreen(modifier: Modifier = Modifier) {
    val rewards = StkRewardRepository.rewards

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_sb),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(60.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Exclusive Rewards",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp,
                    color = MaterialTheme.colorScheme.primary // Changed color
                )
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = "Claim your special offers now!",
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant // Changed color
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(rewards) { reward ->
                StkRewardCard(
                    reward = reward,
                    modifier = Modifier.fillMaxWidth()
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
fun StkRewardScreenPreview() {
    StkTheme {
        RewardScreen()
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun StkRewardActivityPreview() {
    val navController = rememberNavController()
    StkTheme {
        StkRewardActivity(navHostController = navController)
    }
}