package com.example.stk.ui.pages.splash

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme // Ditambahkan import
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stk.R

@Composable
fun StkSplashScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit
) {
    // primaryColor di sini sekarang akan mengambil nilai dari MaterialTheme.colorScheme.primary
    // yang didefinisikan di StkColor.kt Anda.
    val primaryColorFromTheme = MaterialTheme.colorScheme.primary

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_sb),
                contentDescription = "App Logo",
                modifier = Modifier.size(180.dp)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
        ) {
            Button(
                onClick = onLoginClick,
                // Menggunakan primaryColor dari tema untuk latar belakang tombol Login
                colors = ButtonDefaults.buttonColors(containerColor = primaryColorFromTheme),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                // Menggunakan onPrimaryColor dari tema untuk teks tombol Login
                Text("Login", fontSize = 16.sp, color = MaterialTheme.colorScheme.onPrimary)
            }

            Button(
                onClick = onRegisterClick,
                // Latar belakang tombol Register tetap putih, bordernya menggunakan primaryColor dari tema
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, primaryColorFromTheme), // Menggunakan primaryColor dari tema
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                // Teks tombol Register menggunakan primaryColor dari tema
                Text("Register", fontSize = 16.sp, color = primaryColorFromTheme)
            }
        }
    }
}