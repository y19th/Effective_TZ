plugins {
    id("android-setup")
    id("compose-setup")
}

android.namespace = "com.y19th.feature.home.root"

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.ui)
    implementation(projects.core.domain)
    implementation(projects.core.navigation)

    implementation(projects.feature.home.main)
    implementation(projects.feature.home.favourites)
    implementation(projects.feature.home.account)
}