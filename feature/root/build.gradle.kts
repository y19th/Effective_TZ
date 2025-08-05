plugins {
    id("android-setup")
    id("compose-setup")
}

android.namespace = "com.y19th.feature.root"

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.ui)
    implementation(projects.core.navigation)
    implementation(projects.core.local)
    implementation(projects.core.domain)


    implementation(projects.feature.authenticate)
    implementation(projects.feature.home.root)
}