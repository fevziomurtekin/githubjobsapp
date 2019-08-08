package com.fevziomurtekin.githubjobs.di

import com.fevziomurtekin.githubjobs.JobsViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val appModule = applicationContext {

    viewModel { JobsViewModel() }
}