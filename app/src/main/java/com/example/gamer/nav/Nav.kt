package com.example.gamer.nav
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.gamer.screens.ForgotPasswordScreen
import com.example.gamer.screens.LoginScreen
import com.example.gamer.screens.OTPValidationScreen
import com.example.gamer.screens.SignUpScreen
import com.example.gamer.screens.SplashScreen

@Composable
fun Nav(navCon: NavHostController){
    NavHost(navCon,startDestination = "splash") {
        composable("splash") { SplashScreen(navCon) }
        composable("login") { LoginScreen(navCon) }
        composable("signup") { SignUpScreen(navCon) }
        composable("forgot") { ForgotPasswordScreen(navCon) }
        composable(
            route = AppRoutes.OTP_VALIDATION_FULL, // "otp_validation_screen/{expectedOtp}"
            arguments = listOf(navArgument("expectedOtp") { type = NavType.StringType })
        ) { backStackEntry ->
            val expectedOtp = backStackEntry.arguments?.getString("expectedOtp").orEmpty()
            OTPValidationScreen(navCon, expectedOtp) // <-- pass it; we’ll validate against it
        }
        composable("reset") {}
        composable("home") {}
    }
}