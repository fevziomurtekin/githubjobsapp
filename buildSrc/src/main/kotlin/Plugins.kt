object Plugins{
    val fabricMavenUrl              = "https://maven.fabric.io/public"
    val androidGradlePlugin         = "com.android.tools.build:gradle:${Versions.buildToolVersion}"
    val googleVersionGradlePlugin   = "com.google.gms:google-services:${Versions.googleServiceVersion}"
    val fabricGradlePlugin          = "io.fabric.tools:gradle:${Versions.fabricVersion}"
    val kotlinGradlePlugin          = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    val mavenGradlePlugin           = "com.github.dcendents:android-maven-gradle-plugin:${Versions.mavenGradleVersion}"
    val jitpackUrl                  = "https://jitpack.io"
    val androidApplication          = "com.android.application"
    val kotlinAndroid               = "android"
    val kotlinAndroidExtensions     = "android.extensions"
    val kotlinKaptExtensions        = "kapt"
    val googleServices              = "com.google.gms.google-services"

    val applicationId               = "com.fevziomurtekin.githubjobs"
    val min                         = 21
    val compile                     = 28
    val versionCode                 = 1
    val versionName                 = "1.0"
    val target                  = compile
    val testInstrumentationRunner   = "android.support.test.runner.AndroidJUnitRunner"
    val javaVersion                 = "1.8"
    val main                        = "main"
    val release                     = "release"
    val proguardTxt                 = "proguard-android.txt"
    val proguardPro                 = "proguard-rules.pro"
    val baseApplicationId           = "com.fevziomurtekin.githubjobs.base"
    val androidlibrary              = "com.android.library"
    /** PACKAGING OPTIONS */
    val metaLicense                 = "META-INF/LICENSE"
    val metaDependecies             = "META-INF/DEPENDENCIES"
    val metaIndex                   = "META-INF/INDEX.LIST"
}