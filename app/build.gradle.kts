plugins{
    id(Plugins.androidApplication)
    //id(Plugins.googleServices)
    kotlin(Plugins.kotlinAndroid)
    kotlin(Plugins.kotlinAndroidExtensions)
    kotlin(Plugins.kotlinKaptExtensions)

}

android{
    compileSdkVersion(Plugins.compile)

    defaultConfig{
        applicationId = Plugins.applicationId
        minSdkVersion(Plugins.min)
        targetSdkVersion(Plugins.target)
        versionCode = Plugins.versionCode
        versionName = Plugins.versionName
        multiDexEnabled = true
        testInstrumentationRunner = Plugins.testInstrumentationRunner
    }

    buildTypes {
        getByName(Plugins.release) {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile(Plugins.proguardTxt), Plugins.proguardPro)
        }
    }

    packagingOptions{
        exclude(Plugins.metaDependecies)
        exclude(Plugins.metaLicense)
        exclude(Plugins.metaIndex)
    }

    compileOptions{
        setSourceCompatibility(Plugins.javaVersion)
        setTargetCompatibility(Plugins.javaVersion)
    }

    lintOptions{
        isCheckReleaseBuilds = false
        isAbortOnError = false
    }

    androidExtensions { isExperimental = true }


    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies{
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", Versions.kotlinVersion))

    /** androidx & material design **/
    implementation(Dependencies.appcompat)
    implementation(Dependencies.constraint_layout)
    implementation(Dependencies.vector_drawable)
    implementation(Dependencies.material_design)
    /** viewmodel & livedata **/
    implementation(Dependencies.lifecycle)
    kapt(Dependencies.lifecycle_compiler)
    implementation(Dependencies.lifecycle_test)
    /** recyclerview **/
    implementation(Dependencies.recyclerview)
    /** glide **/
    implementation(Dependencies.glide)
    kapt(Dependencies.glide_compiler)
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
    /** rx **/
    implementation(Dependencies.rxjava)
    implementation(Dependencies.rxandroid)
    /** koin **/
    implementation(Dependencies.koin)
    implementation(Dependencies.koin_architecture)
    testImplementation(Dependencies.koin_test)
    androidTestImplementation(Dependencies.koin_android_test)
    /** firebase **/
    implementation(Dependencies.firebase_core)
    implementation(Dependencies.firebase_messaging)
    implementation(Dependencies.firebase_crash)
    /** navigation **/
    implementation(Dependencies.navigation_fragment)
    implementation(Dependencies.navigation_ui)
    /** pagging **/
    implementation(Dependencies.pagging)
    /** leak canary **/
    implementation(Dependencies.leakcanary)
    kapt(Dependencies.leakcanary_noop)

    /** modules **/
    implementation(project(Modules.data))
    implementation(project(Modules.base))
    implementation(project(Modules.view))

}
