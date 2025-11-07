package com.example.gamer.nav

object AppRoutes {
    const val SPLASH = "splash_screen"
    const val LOGIN = "login_screen"
    const val SIGN_UP = "sign_up_screen"
    const val FORGOT_PASSWORD = "forgot_password_screen"
    // Route with argument for the expected OTP code
    const val OTP_VALIDATION_BASE = "otp_validation_screen"
    const val OTP_VALIDATION_FULL = "$OTP_VALIDATION_BASE/{expectedOtp}"
    const val RESET_PASSWORD = "reset_password_screen"
    const val HOME = "home_screen"

    // Helper function to safely build the OTP route
    fun otpValidationRoute(otp: String) = "$OTP_VALIDATION_BASE/$otp"
}