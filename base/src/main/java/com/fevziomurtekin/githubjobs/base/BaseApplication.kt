package com.fevziomurtekin.githubjobs.base

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber


abstract class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Timber.d("Application start")

    }
}
