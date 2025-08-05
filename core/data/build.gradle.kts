plugins {
    id("android-setup")
    alias(libs.plugins.kotlinSerialization)
}

android.namespace = "com.y19th.core.data"

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.domain)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson.converter)
}
