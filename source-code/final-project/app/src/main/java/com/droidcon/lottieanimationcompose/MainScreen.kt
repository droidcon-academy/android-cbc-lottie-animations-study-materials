package com.droidcon.lottieanimationcompose

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val loaderComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        val loaderProgress by animateLottieCompositionAsState(
            composition = loaderComposition,
            iterations = LottieConstants.IterateForever,
        )
        LottieAnimation(
            modifier = Modifier.size(200.dp),
            composition = loaderComposition,
            progress = { loaderProgress },
        )

        val likeComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.like))
        var isLiked by remember {
            mutableStateOf(false)
        }
        val likeProgress by animateFloatAsState(
            targetValue = if (isLiked) 0.6f else 0f,
            animationSpec = tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
            label = "likeProgress"
        )
        LottieAnimation(
            composition = likeComposition,
            progress = { likeProgress },
            modifier = Modifier
                .size(200.dp)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null,
                    onClick = { isLiked = !isLiked }
                )
        )

        val thermometerComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.thermometer))
        var thermometerProgress by remember {
            mutableStateOf(0f)
        }
        LottieAnimation(
            composition = thermometerComposition,
            progress = { thermometerProgress },
        )
        Slider(value = thermometerProgress, onValueChange = { thermometerProgress = it })
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}