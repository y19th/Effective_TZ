plugins {
    alias(libs.plugins.kotlin.android)
    id("android-setup")
    id("compose-setup")
}
android.namespace = "com.y19th.core.ui"

dependencies {
    api(libs.unstyled.core)
}