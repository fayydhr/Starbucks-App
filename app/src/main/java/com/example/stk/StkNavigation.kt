package com.example.stk

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.stk.ui.pages.claimreward.StkRewardActivity
import com.example.stk.ui.pages.menu.StkMenuActivity
import com.example.stk.ui.pages.profile.StkProfileActivity
import com.example.stk.ui.pages.signin.StkSignInScreen
import com.example.stk.ui.pages.signup.StkSignUpScreen
import com.example.stk.ui.pages.splash.StkSplashScreen
import com.example.stk.ui.pages.otp.StkOTPScreen

sealed class StkRoute(val name: String) {
    object StkSplashScreen : StkRoute("Splash")
    object StkSignInScreen : StkRoute("SignIn")
    object StkSignUpScreen : StkRoute("SignUp")
    object StkMenuScreen : StkRoute("Menu")
    object StkProfileScreen : StkRoute("Profile")
    object StkRewardScreen : StkRoute("Reward")
    object StkOTPScreen : StkRoute("OTP")
}

@Composable
fun StkNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = StkRoute.StkSplashScreen.name
    ) {
        composable(route = StkRoute.StkSplashScreen.name) {
            StkSplashScreen(
                onLoginClick = {
                    navHostController.navigate(StkRoute.StkSignInScreen.name)
                },
                onRegisterClick = {
                    navHostController.navigate(StkRoute.StkSignUpScreen.name)
                }
            )
        }

        composable(route = StkRoute.StkSignInScreen.name) {
            StkSignInScreen(
                onSignInClick = {
                    navHostController.navigate(StkRoute.StkMenuScreen.name)
                },
                onSignUpClick = {
                    navHostController.navigate(StkRoute.StkSignUpScreen.name)
                }
            )
        }

        composable(route = StkRoute.StkSignUpScreen.name) {
            StkSignUpScreen(
                onSignUpClick = {
                    navHostController.navigate(StkRoute.StkOTPScreen.name)
                },
                onSignInClick = {
                    navHostController.navigate(StkRoute.StkSignInScreen.name)
                }
            )
        }

        composable(route = StkRoute.StkOTPScreen.name) {
            StkOTPScreen(
                onOTPSubmit = {
                    navHostController.navigate(StkRoute.StkMenuScreen.name)
                }
            )
        }

        composable(route = StkRoute.StkMenuScreen.name) {
            StkMenuActivity(navHostController)
        }

        composable(route = StkRoute.StkRewardScreen.name) {
            StkRewardActivity(navHostController)
        }

        composable(route = StkRoute.StkProfileScreen.name) {
            StkProfileActivity(navHostController)
        }
    }
}