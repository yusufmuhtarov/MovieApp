package com.example.movieapp.presentation.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.presentation.components.lottie_icons.LottieItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val SPLASH_SCREEN_TIME_HILLIS = 3000L

@Composable
fun SplashScreen(
    onNavigateNext: () -> Unit,
    modifier: Modifier = Modifier
) {
    val systemUiController = rememberSystemUiController()
    val scope = rememberCoroutineScope()
    val colorBackground = MaterialTheme.colorScheme.background

    LaunchedEffect(
        key1 = true,
    ) {
        scope.launch {
            delay(SPLASH_SCREEN_TIME_HILLIS)
            onNavigateNext()
        }
    }
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LottieItems(
            modifier = Modifier.size(240.dp),
            lottie = R.raw.movie_splash_lottie
        )
    }
    SideEffect {
        systemUiController.setStatusBarColor(colorBackground)
        systemUiController.setNavigationBarColor(colorBackground)
    }
}
