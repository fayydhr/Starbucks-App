plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") // Ensure this is present
}

android {
    namespace = "com.example.stk"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.stk"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "2.0.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android & Compose dependencies
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Navigation dependencies (ensure these are present and correct)
    // Removed hardcoded versions if they conflict with BOM or other dependencies.
    // If you absolutely need specific older versions of UI/Material, you might need to adjust BOM or other dependencies.
    // However, it's generally best to let BOM manage these.
    // Let's remove the specific androidx.compose.ui:ui:1.6.8 and androidx.compose.material:material:1.6.8 as BOM should cover it.
    // If issues arise after removal, we can re-evaluate.
    implementation(libs.androidx.navigation.compose)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.21.0-beta")

    // TEST DEPENDENCIES - **CRUCIAL FIXES HERE**
    testImplementation(libs.junit) // Standard JUnit
    androidTestImplementation(libs.androidx.junit) // AndroidX JUnit for instrumented tests
    androidTestImplementation(libs.androidx.espresso.core) // Espresso for UI testing
    androidTestImplementation(platform(libs.androidx.compose.bom)) // BOM for Compose testing libraries
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI test rules
    debugImplementation(libs.androidx.ui.tooling) // Compose tooling for previews
    debugImplementation(libs.androidx.ui.test.manifest) // Compose test manifest utility
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("junit:junit:4.13.2")

}