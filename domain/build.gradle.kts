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
    implementation(Dependencies.lifecycle)
    /** data module **/
    implementation(project(Modules.data))

}
