package com.example.stk.ui.pages.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.* // Added import for MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.stk.R
import com.example.stk.ui.components.StkBottomNavigationBar

@Composable
fun StkProfileActivity(
    navHostController: NavHostController
) {
    Scaffold(
        bottomBar = {
            StkBottomNavigationBar(navController = navHostController)
        }
    ) { innerPadding ->
        StkProfileScreen(
            modifier = Modifier.padding(innerPadding),
            onSignInClick = {
                // Implement actual sign out logic here
                navHostController.navigate("SignIn") {
                    popUpTo(0) { inclusive = true } // Clear back stack on logout
                }
            }
        )
    }
}

@Composable
fun StkProfileScreen(
    modifier: Modifier = Modifier,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary, // Changed color
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.profile_pic),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .padding(bottom = 24.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), // Using theme surface color
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ProfileField(label = "Name", value = "testaja")
                Spacer(modifier = Modifier.height(16.dp))
                ProfileField(label = "Email", value = "testaja@gmail.com")
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            onClick = onSignInClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error // Using theme error color for logout
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Log Out", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        }
    }
}

@Composable
fun ProfileField(label: String, value: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = label, fontSize = 16.sp, color = MaterialTheme.colorScheme.onSurfaceVariant) // Using theme color
        Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Medium, color = MaterialTheme.colorScheme.onSurface) // Using theme color
    }
}