package com.example.stk.ui.pages.otp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.* // Added import for MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StkOTPScreen(
    onOTPSubmit: (String) -> Unit = {}
) {
    val otpLength = 4
    var otpValues by remember { mutableStateOf(List(otpLength) { "" }) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Verification Code",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary, // Changed color
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "We have sent the verification code to your email address",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onBackground, // Using theme color
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                otpValues.forEachIndexed { index, value ->
                    OutlinedTextField(
                        value = value,
                        onValueChange = {
                            if (it.length <= 1 && it.all { char -> char.isDigit() }) {
                                otpValues = otpValues.toMutableList().also { list -> list[index] = it }
                            }
                        },
                        singleLine = true,
                        modifier = Modifier
                            .width(60.dp)
                            .height(64.dp),
                        textStyle = LocalTextStyle.current.copy(fontSize = 24.sp, fontWeight = FontWeight.Bold),
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = MaterialTheme.colorScheme.primary, // Changed color
                            unfocusedBorderColor = MaterialTheme.colorScheme.primary, // Changed color
                            cursorColor = MaterialTheme.colorScheme.primary // Changed color
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    val fullOTP = otpValues.joinToString("")
                    onOTPSubmit(fullOTP)
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary), // Changed color
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Verify", color = MaterialTheme.colorScheme.onPrimary) // Changed color
            }
        }
    }
}