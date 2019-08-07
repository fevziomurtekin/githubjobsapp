plugins{
    id(Plugins.androidlibrary)
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

}
