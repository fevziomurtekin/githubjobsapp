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

    buildTypes {
        getByName(Plugins.debug) {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile(Plugins.proguardTxt), Plugins.proguardPro)
        }
    }


}

dependencies{
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    /** retrofit **/
    implementation(Dependencies.okhttp)
    implementation(Dependencies.okhttp_logging)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofit_convertor)
    implementation(Dependencies.retrofit_adapter)
    /** gson **/
    implementation(Dependencies.gson)
    /** room **/
    implementation(Dependencies.room)
    implementation(Dependencies.room_rxjava)
    kapt(Dependencies.room_compiler)
    implementation(Dependencies.room_androidx)
    /** timber **/
    implementation(Dependencies.timber)
    implementation(Dependencies.lifecycle)
    /** data module **/
    implementation(project(Modules.data))

}
