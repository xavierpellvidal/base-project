plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "${AppVersions.APPLICATION_ID}.di"
    compileSdk = AppVersions.COMPILE_SDK

    defaultConfig {
        minSdk = AppVersions.MIN_SDK
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppVersions.javaVersion
        targetCompatibility = AppVersions.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppVersions.JVM_TARGET
    }
}

dependencies {
    implementation(project(":core:api"))
    implementation(project(":core:database"))
    implementation(project(":data"))
    implementation(project(":domain"))
}
