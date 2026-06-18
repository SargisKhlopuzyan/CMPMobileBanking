rootProject.name = "CMPMobileBanking"
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
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

include(":androidApp")
include(":desktopApp")
include(":shared")
include(":designsystem")
include(":feature:authentication:ui")
include(":feature:authentication:domain")
include(":feature:authentication:data")
include(":feature:main:ui")
include(":feature:main:domain")
include(":core:ui")
include(":core:network")
include(":core:database")
include(":core:navigation")
include(":feature:transfersAndPayments:ui")
include(":feature:applications:ui")
include(":feature:menu:ui")
