plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android") version "1.9.25" // En güncel Kotlin sürümü
    id("com.google.dagger.hilt.android") version "2.44"
    id("com.google.devtools.ksp") version "1.9.25-1.0.20" // KSP'nin en güncel sürümü
}

android {
    namespace = "com.faturapay"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.faturapay"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
        kotlinCompilerExtensionVersion = "1.5.15" // En güncel Compose Compiler sürümü
    }

    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

dependencies {
    // **Jetpack Compose**
    implementation(platform("androidx.compose:compose-bom:2025.02.00")) // BOM kullanımı önerilir
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.navigation:navigation-compose:2.7.5")
    debugImplementation("androidx.compose.ui:ui-tooling")
    implementation("androidx.activity:activity-compose:1.7.2")

    // **Lifecycle & ViewModel**
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0")
    implementation("androidx.compose.runtime:runtime-livedata:1.7.8")

    // **Retrofit & Gson (API Çağrıları)**
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    // **Room Database (Local Veri Saklama)**
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // **DataStore (SharedPreferences yerine)**
    implementation("androidx.datastore:datastore-preferences:1.1.0")

    // **WorkManager (Bildirimler için)**
    implementation("androidx.work:work-runtime-ktx:2.8.0")

    // **MPAndroidChart (Grafikler için)**
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")

    // **Hilt (Dependency Injection)**
    implementation("com.google.dagger:hilt-android:2.44")
    ksp("com.google.dagger:hilt-android-compiler:2.44")

    // **Testing**
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
