import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.serialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_18)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    jvm()
    
    js {
        browser()
        binaries.executable()
    }
    
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    
    sourceSets {

        commonMain.dependencies {
            //find latest compose multiplatform dependencies at https://klibs.io/
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            //navigation for compose multiplatform
            implementation(libs.navigation.compose)
            implementation(libs.serialization.json)

            //ktor client for networking
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.auth)

            //coroutines
            implementation(libs.kotlinx.coroutines.core)

            //viewmodel
            api(libs.androidx.lifecycle.viewmodel)

            //koin
            api(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewModel)

            //datastore preferences
            api(libs.multiplatform.settings)
            api(libs.multiplatform.settings.no.arg)

            //constraints
            implementation("tech.annexflow.compose:constraintlayout-compose-multiplatform:0.6.1")

            implementation("tech.annexflow.compose:constraintlayout-compose-multiplatform:0.6.1-shaded-core")

            implementation("tech.annexflow.compose:constraintlayout-compose-multiplatform:0.6.1-shaded")


            implementation("io.github.dokar3:sonner:0.3.8") //https://github.com/dokar3/compose-sonner

        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
            //ktor client for networking
            implementation(libs.ktor.client.android)
            //coroutines
            implementation(libs.kotlinx.coroutines.android)
            //koin
            implementation(libs.koin.android)
            implementation(libs.koin.androidx.compose)
        }
        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)

            //ktor client for networking
            implementation(libs.ktor.client.cio)

            //viewmodel
            implementation(libs.kotlinx.coroutinesSwing)
        }
        iosMain.dependencies {
            //ktor client for networking
            implementation(libs.ktor.client.darwin)
        }
        jsMain.dependencies {
            //ktor client for networking
            implementation(libs.ktor.client.js)
        }
    }
}

android {
    namespace = "com.vivek.demo"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.vivek.demo"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "com.vivek.demo.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "com.vivek.demo"
            packageVersion = "1.0.0"
        }
    }
}
