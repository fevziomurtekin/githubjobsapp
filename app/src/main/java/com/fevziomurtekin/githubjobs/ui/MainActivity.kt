package com.fevziomurtekin.githubjobs.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fevziomurtekin.githubjobs.view.JobsViewModel
import com.fevziomurtekin.githubjobs.R
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<JobsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
