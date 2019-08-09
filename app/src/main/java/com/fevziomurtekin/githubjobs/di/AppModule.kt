package com.fevziomurtekin.githubjobs.di

import com.fevziomurtekin.githubjobs.view.JobsViewModel
import com.fevziomurtekin.githubjobs.base.GlideModule
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {

    viewModel { JobsViewModel() }

    bean{ GlideModule() }
}