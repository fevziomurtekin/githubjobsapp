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
    /** gson **/
    implementation(Dependencies.gson)
}
