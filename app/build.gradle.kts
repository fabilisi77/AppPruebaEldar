plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.eldarapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.eldarapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        viewBinding = true
    }
    kotlin {
        jvmToolchain(8)
    }
}

dependencies {

    val navaVersion = "2.7.3"
    val retrofitVersion = "2.9.0"
    val glideVersion ="4.11.0"
    val viewmodelVersion ="2.2.0"

    //NavComponent
    implementation("androidx.navigation:navigation-fragment-ktx:$navaVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navaVersion")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.google.code.gson:gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    //Glide
    implementation ("com.github.bumptech.glide:glide:$glideVersion")
    annotationProcessor ("com.github.bumptech.glide:compiler:$glideVersion")

    //ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$viewmodelVersion")
    //livedata
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$viewmodelVersion")



    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}