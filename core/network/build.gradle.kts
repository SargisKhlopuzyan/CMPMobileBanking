import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.androidLint)
}

kotlin {

    jvm()

    // Target declarations - add or remove as needed below. These define
    // which platforms this KMP module supports.
    // See: https://kotlinlang.org/docs/multiplatform-discover-project.html#targets
    android {
        namespace = "com.sargis.khlopuzyan.core.network"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    // For iOS targets, this is also where you should
    // configure native binary output. For more information, see:
    // https://kotlinlang.org/docs/multiplatform-build-native-binaries.html#build-xcframeworks

    // A step-by-step guide on how to include this library in an XCode
    // project can be found here:
    // https://developer.android.com/kotlin/multiplatform/migrate
    val xcfName = "core:networkKit"

    listOf(
        //iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = xcfName
            isStatic = true
        }
    }

    // Source set declarations.
    // Declaring a target automatically creates a source set with the same name. By default, the
    // Kotlin Gradle Plugin creates additional source sets that depend on each other, since it is
    // common to share sources between related targets.
    // See: https://kotlinlang.org/docs/multiplatform-hierarchy.html
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.core.domain)

                implementation(libs.kotlin.stdlib)
                implementation(libs.compose.runtime)

                implementation(libs.koin.core)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.client.serialization)
                implementation(libs.ktor.client.logging)

                implementation(libs.kotlinx.serialization)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.koin.android)
                implementation(libs.ktor.client.android)
            }
        }

//        getByName("androidDeviceTest") {
//            dependencies {
//                implementation(libs.androidx.core)
//                implementation(libs.androidx.runner)
//                implementation(libs.androidx.testExt.junit)
//            }
//        }

        iosMain {
            dependencies {
                implementation(libs.ktor.client.ios)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.ktor.client.desktop)
                implementation(libs.ktor.client.android)
                implementation(libs.kotlinx.coroutinesSwing)
            }
        }
    }
}