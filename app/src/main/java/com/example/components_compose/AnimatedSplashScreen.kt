package com.example.components_compose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.components_compose.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(4000)
        navController.popBackStack() //colocado aqui para quando apertar para voltar ir para o menu inicial e nao para splash novamente
        navController.navigate(Screen.DrawerScreen.HomeScreen.route)
    }

    Splash(alpha = alphaAnimation.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.jetpack_compose),
            contentDescription = "Splash Image",
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .alpha(alpha = alpha)
        )

    }



//    //Testando no modo normal
//    @Composable
//    @Preview
//    fun SplashScreenPreview() {
//        Splash(alpha = 1f)
//    }
//
//    //Testando no modo dark
//    @Composable
//    @Preview(uiMode = UI_MODE_NIGHT_YES)
//    fun SplashScreenDarkPreview() {
//        Splash(alpha = 1f)
}