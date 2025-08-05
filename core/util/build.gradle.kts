plugins {
    id("android-setup")
    id("compose-setup")
    alias(libs.plugins.kotlinSerialization)
}
android.namespace = "com.y19th.core.util"

dependencies {
    api(projects.core.resources)

    api(libs.kotlinx.coroutines.core)
    api(libs.koin.core)
    api(libs.kotlinx.serialization.json)
    api(libs.bundles.dextension)
    api(libs.androidx.core.ktx)
    api(libs.androidx.activity.compose)
}