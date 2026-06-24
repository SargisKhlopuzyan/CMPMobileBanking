import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    jvm()

    androidLibrary {
       namespace = "com.sargis.khlopuzyan.cmpmobilebanking.shared"
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

//    val xcf = XCFramework()

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true

//            export(project(":core:data"))
//
//            export(project(":feature:search:data"))
//            export(project(":feature:search:domain"))
//            export(project(":feature:search:ui"))
//
//            export(project(":feature:details:data"))
//            export(project(":feature:details:domain"))
//            export(project(":feature:details:ui"))
//            xcf.add(this)
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.compose.uiToolingPreview)

            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(projects.core.designsystem)
            implementation(projects.core.navigation)
            implementation(projects.core.fakeDataSource)
            implementation(projects.core.database)
            implementation(projects.core.network)
            implementation(projects.feature.home.data)
            implementation(projects.feature.home.domain)
            implementation(projects.feature.home.ui)

            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.components.resources)

            implementation(libs.navigation.compose)

            implementation(libs.compose.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}