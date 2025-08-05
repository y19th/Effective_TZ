rootProject.name = "Effective_TZ"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }

    includeBuild("build-system/convention")
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
                includeGroupAndSubgroups("app.cash")
                includeGroupAndSubgroups("io")
            }
        }
        mavenCentral()
        maven("https://jitpack.io")
    }
}

include(
    ":app",
    ":core",
    ":core:ui",
    ":core:data",
    ":core:util",
    ":core:navigation",
    ":core:local",
    ":core:domain",
    ":core:resources",
    ":feature",
    ":feature:root",
    ":feature:home",
    ":feature:home:root",
    ":feature:home:main",
    ":feature:home:favourites",
    ":feature:home:account",
    ":feature:authenticate",
)
