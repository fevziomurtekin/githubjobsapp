package com.fevziomurtekin.githubjobs.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import java.util.concurrent.Executor

class GithubjobDataFactory (
    private val githubjobsApi: GithubjobsApi,
    private val retryExecutor: Executor,
    private val location:String,
    private val description:String
): DataSource.Factory<String,JobsResponse>(){
    val sourceLiveData = MutableLiveData<PageKeyedJobsDataSource>()
    override fun create(): DataSource<String, JobsResponse> {
        val source = PageKeyedJobsDataSource(githubjobsApi,retryExecutor,location,description)
        sourceLiveData.postValue(source)
        return source
    }

}