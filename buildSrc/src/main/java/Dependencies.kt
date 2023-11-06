object Kotlin {
    val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"
}

object Google {
    val material = "com.google.android.material:material:${Versions.material}"
}

object Android {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Compose {
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    const val composeUiToolingPreview =
        "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.composeMaterial}"
    const val navigation = "androidx.navigation:navigation-compose:${Versions.composeNavigation}"
}

object Dagger {
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-compiler:${Versions.hiltKapt}"
}