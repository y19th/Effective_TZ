plugins {
    id("android-setup")
    alias(libs.plugins.ksp.plugin)
    alias(libs.plugins.kotlinSerialization)
}

android.namespace = "com.y19th.core.local"

dependencies {
    implementation(libs.androidx.room.common)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.sqlite.bundled)
    ksp(libs.androidx.room.compiler)

    implementation(projects.core.util)
    implementation(projects.core.domain)
}

ksp {
    arg("room.schemaLocation", "${projectDir}/schemas")
}