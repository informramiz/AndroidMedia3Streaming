plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.streamingapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.streamingapp"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.5"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Compose Integrations
    implementation("androidx.compose.runtime:runtime-livedata")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    implementation("androidx.navigation:navigation-compose:2.6.0")

    // Ktx
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    val activity_version = "1.7.2"
    implementation("androidx.activity:activity-ktx:$activity_version")
    implementation("androidx.activity:activity-compose:$activity_version")
    implementation("androidx.fragment:fragment-ktx:1.6.0")

    // Compose
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Hilt
    val dagger_group_hilt_version = "2.44"
    implementation("com.google.dagger:hilt-android:$dagger_group_hilt_version")
    kapt("com.google.dagger:hilt-compiler:$dagger_group_hilt_version")
    val hilt_version = "1.0.0"
    implementation("androidx.hilt:hilt-work:$hilt_version")
    kapt("androidx.hilt:hilt-compiler:$hilt_version")
    implementation("androidx.hilt:hilt-navigation-compose:$hilt_version")

    // Media3
    val media3_version = "1.1.0-rc01"
    implementation("androidx.media3:media3-exoplayer:$media3_version")
    implementation("androidx.media3:media3-ui:$media3_version")
    implementation("androidx.media3:media3-exoplayer-dash:$media3_version")

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}