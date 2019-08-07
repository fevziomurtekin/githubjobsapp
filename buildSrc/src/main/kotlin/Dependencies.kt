import sun.misc.Version



object Dependencies{

    /* androidX & material design */
    val appcompat           = "androidx.appcompat:appcompat:${Versions.appcompat_version}"
    val constraint_layout   = "androidx.constraintlayout:constraintlayout:${Versions.constraint_layout_version}"
    val vector_drawable     = "androidx.vectordrawable:vectordrawable:${Versions.vector_drawable_version}"
    val material_design     = "com.google.android.material:material:${Versions.material_version}"

    /* ViewModel & LiveData  */
    val lifecycle           = "android.arch.lifecycle:extensions:${Versions.androidArchitectureVersion}"
    val lifecycle_compiler  = "android.arch.lifecycle:compiler:${Versions.androidArchitectureVersion}"
    val lifecycle_test      = "android.arch.core:core-testing:${Versions.androidArchitectureVersion}"

    /* Recyclerview */
    val recyclerview        = "androidx.recyclerview:recyclerview:${Versions.recyclerview_version}"

    /* Glide */
    val glide               = "com.github.bumptech.glide:glide:${Versions.glide_version}"
    val glide_compiler      = "com.github.bumptech.glide:compiler:${Versions.glide_version}"

    /* Retrofit */
    val okhttp              = "com.squareup.okhttp3:okhttp:${Versions.okhttp3_version}"
    val okhttp_logging      = "com.squareup.okhttp3:logging-interceptor:${Versions.logging_version}"
    val retrofit            = "com.squareup.retrofit2:retrofit:${Versions.retrofit2_version}"
    val retrofit_convertor  = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2_converter_version}"
    val retrofit_adapter    = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2_version}"

    /* Gson */
    val gson                = "com.google.code.gson:gson:${Versions.gson_version}"

    /* Room */
    val room                = "android.arch.persistence.room:runtime:${Versions.room_version}"
    val room_rxjava         = "android.arch.persistence.room:rxjava2:${Versions.room_version}"
    val room_compiler       = "androidx.room:room-compiler:${Versions.room_version}"
    val room_androidx       = "androidx.room:room-runtime:${Versions.room_version}"

    /* Timber */
    val timber              = "com.jakewharton.timber:timber:${Versions.timber_version}"

    /*Rx*/
    val rxjava              = "io.reactivex.rxjava2:rxjava:${Versions.rxjava_version}"
    val rxandroid           = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid_version}"

    /* Koin */
    val koin                = "org.koin:koin-android:${Versions.koin_version}"
    val koin_architecture   = "org.koin:koin-android-architecture:${Versions.koin_version}"
    val koin_test           = "org.koin:koin-test:${Versions.koin_version}"
    val koin_android_test   = "org.koin:koin-test:${Versions.koin_version}"

    /*Firebase*/
    val firebase_core       = "com.google.firebase:firebase-core:${Versions.firebase_core_version}"
    val firebase_messaging  = "com.google.firebase:firebase-messaging:${Versions.firebase_messaging_version}"
    val firebase_crash      = "com.google.firebase:firebase-crash:${Versions.firebase_crash_version}"

    /* Android Test */
    val jUnit               = "junit:junit:${Versions.junit_version}"
    val mockito             = "org.mockito:mockito-core:${Versions.mockito_version}"

    /* Navigation */
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation_version}"
    val navigation_ui       = "androidx.navigation:navigation-ui-ktx:${Versions.navigation_version}"

    /* Pagging */
    val pagging             = "android.arch.paging:runtime:${Versions.pagging_version}"

    /* Leak canary */
    val leakcanary          = "com.squareup.leakcanary:leakcanary-android:${Versions.leakcanary_version}"
    val leakcanary_noop     = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakcanary_version}"

}
