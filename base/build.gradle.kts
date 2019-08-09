
plugins{
    id(Plugins.androidlibrary)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinAndroidExtensions)
    kotlin(Plugins.kotlinKaptExtensions)
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
    implementation(Dependencies.constraint_layout)
    /** koin **/
    implementation(Dependencies.koin)
    implementation(Dependencies.koin_architecture)
    testImplementation(Dependencies.koin_test)
    androidTestImplementation(Dependencies.koin_android_test)
    /** glide **/
    implementation(Dependencies.glide)
    kapt(Dependencies.glide_compiler)
    implementation(Dependencies.glide_okhttp) {
        exclude(mapOf("group" to "glide-parent"))
    }
    /** Timber **/
    implementation(Dependencies.timber)
    /** Recyclerview **/
    implementation(Dependencies.recyclerview)
    /** data modules **/
    implementation(project(Modules.data))
}
