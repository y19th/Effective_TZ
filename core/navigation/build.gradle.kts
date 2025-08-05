plugins {
    alias(libs.plugins.kotlin.android)
    id("android-setup")
    id("compose-setup")
    alias(libs.plugins.kotlinSerialization)
}
android.namespace = "com.y19th.core.navigation"

dependencies {
    implementation(projects.core.util)
}