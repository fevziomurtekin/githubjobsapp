package com.fevziomurtekin.githubjobs

import android.app.Application
import com.fevziomurtekin.githubjobs.base.BaseApplication
import com.fevziomurtekin.githubjobs.di.appModule
import org.koin.android.ext.android.startKoin


class GithubJobsApp : BaseApplication(){

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}