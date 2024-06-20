plugins {
//    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("com.android.library")
    `maven-publish`
}

val groupId = "com.dubizzle"
val artifactId = "ui"
android {
    namespace = "$groupId.$artifactId"
    compileSdk = 34

    defaultConfig {
        minSdk = 23
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    api (libs.ssp.android)
    api (libs.sdp.android)


}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = groupId
            artifactId = artifactId
            version = "0.0.1"

            afterEvaluate {
                from(components["release"])
            }
        }

    }

    repositories {
        maven {
            name = "uilib"
            url = uri("${project.buildDir}/repo")
        }
    }
}