plugins {
    id("android-setup")
    id("compose-setup")
}

android.namespace = "com.y19th.feature.authenticate"

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.ui)
    implementation(projects.core.domain)
    implementation(projects.core.navigation)
}