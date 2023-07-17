// The challenge was to create a thermometer animation wich can be manually controlled by a slider

val thermometerComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.thermometer))
var thermometerProgress by remember {
    mutableStateOf(0f)
}

LottieAnimation(
    composition = thermometerComposition,
    progress = { thermometerProgress },
)

Slider(value = thermometerProgress, onValueChange = { thermometerProgress = it })
