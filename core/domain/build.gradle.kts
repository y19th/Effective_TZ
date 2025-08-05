plugins {
    id("android-setup")
}

android.namespace = "com.y19th.core.domain"

dependencies {
    implementation(projects.core.util)
    implementation(libs.jetbrains.immutable)
}
