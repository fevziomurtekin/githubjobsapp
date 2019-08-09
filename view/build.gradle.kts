val kotlin_version: String by extra
plugins{
    id(Plugins.androidlibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinAndroidExtensions)
    kotlin(Plugins.kotlinKaptExtensions)
}
apply {
    plugin("kotlin-android")
    plugin("kotlin-android-extensions")
}

android{
    compileSdkVersion(Plugins.compile)
    defaultConfig{
        minSdkVersion(Plugins.min)
        targetSdkVersion(Plugins.target)
        versionCode = Plugins.versionCode
        versionName = Plugins.versionName
    }

}

dependencies{
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", Versions.kotlinVersion))
    /** gson **/
    implementation(Dependencies.gson)
    compile("androidx.core:core-ktx:+")

    implementation(Dependencies.lifecycle)
    kapt(Dependencies.lifecycle_compiler)
    implementation(project(Modules.data))
    implementation(Dependencies.pagging)
    implementation(Dependencies.room_rxjava)
    implementation(Dependencies.material_design)



}
repositories {
    mavenCentral()
}