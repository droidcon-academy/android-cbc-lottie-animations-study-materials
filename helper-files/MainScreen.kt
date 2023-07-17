val likeComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.like))

LottieAnimation(
    composition = likeComposition,
    modifier = Modifier
        .size(200.dp)
)