package com.fevziomurtekin.githubjobs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.fevziomurtekin.githubjobs.data.*
import io.reactivex.disposables.CompositeDisposable

class JobsViewModel : ViewModel(){

    private val service = NetworkService.create()
    var jobList : LiveData<PagedList<JobsResponse>>
    private var disposable = CompositeDisposable()
    private val pageSize = 5
    private val jobDataSourceFactory: JobDataSourceFactory
    val description: String=""
    val location: String =""

    init {
        jobDataSourceFactory = JobDataSourceFactory(disposable,service,description,location)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize*2)
            .setEnablePlaceholders(false)
            .build()

        jobList = LivePagedListBuilder(jobDataSourceFactory,config).build()
    }

    fun getState(): LiveData<Status> = Transformations.switchMap<
            JobDataSource,Status>(jobDataSourceFactory.jobsDataSourceLiveData,JobDataSource::state)

    fun retry() = jobDataSourceFactory.jobsDataSourceLiveData.value?.retry()

    fun listIsEmpty():Boolean = jobList.value?.isEmpty() ?: true

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}