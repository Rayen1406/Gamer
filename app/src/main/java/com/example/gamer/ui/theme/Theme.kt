package com.example.gamer.ui.theme



import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColors = lightColorScheme(
    primary = LightPrimary,
    onPrimary = Color.White,

    background = LightBackground,
    onBackground = LightOnBackground,

    surface = LightSurface,
    onSurface = LightOnSurface,

    error = LightError,
    onError = LightOnError,

    outline = LightOutline
)

private val DarkColors = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = Color.White,

    background = DarkBackground,
    onBackground = DarkOnBackground,

    surface = DarkSurface,
    onSurface = DarkOnSurface,

    error = DarkError,
    onError = DarkOnError,

    outline = DarkOutline
)

@Composable
fun GamerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // keep your existing Type.kt
        shapes = Shapes,         // keep your existing Shape.kt
        content = content
    )
}