package com.fevziomurtekin.githubjobs.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import io.reactivex.disposables.CompositeDisposable

class JobDataSourceFactory (
    private val disposable: CompositeDisposable,
    private val networkService: NetworkService,
    private val description: String,
    private val location:String
): DataSource.Factory<Int,JobsResponse>(){

    val jobsDataSourceLiveData = MutableLiveData<JobDataSource>()

    override fun create(): DataSource<Int, JobsResponse> {
        val jobDataSource = JobDataSource(networkService,description,location,disposable)
        jobsDataSourceLiveData.postValue(jobDataSource)
        return jobDataSource
    }
}