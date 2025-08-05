plugins {
    id("android-setup")
    alias(libs.plugins.kotlinSerialization)
}

android.namespace = "com.y19th.core.resources"

dependencies {
    implementation(libs.kotlinx.serialization.json)
}
