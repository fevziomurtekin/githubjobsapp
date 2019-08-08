package com.fevziomurtekin.githubjobs.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Action
import io.reactivex.schedulers.Schedulers

class JobDataSource (
    val networkService: NetworkService,
    val description: String,
    val location: String,
    val disposable:CompositeDisposable): PageKeyedDataSource<Int,JobsResponse>(){

    var state:MutableLiveData<Status> = MutableLiveData()
    var retryCompletable: Completable? = null

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, JobsResponse>) {

    }

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, JobsResponse>) {
        updateState(Status.LOADING)
        disposable.add(
            networkService.getJobs(1,params.requestedLoadSize,description,location).subscribe({ response->
                updateState(Status.SUCCESS)
                callback.onResult(response,null,2)
            },{ e->
                updateState(Status.ERROR)
                setRetry(Action { loadInitial(params,callback) })
            })
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, JobsResponse>) {
        updateState(Status.LOADING)
        disposable.add(
            networkService.getJobs(params.key,params.requestedLoadSize,description,location)
                .subscribe(
                    {response->
                        updateState(Status.SUCCESS)
                        callback.onResult(response,params.key+1)
                    },{e->
                        updateState(Status.ERROR)
                        setRetry(Action { loadAfter(params,callback) })
                    }
                )
        )
    }

    private fun updateState(state: Status) {
        this.state.postValue(state)
    }

    fun retry(){
        if (retryCompletable != null) {
            disposable.add(retryCompletable!!
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
        }
    }

    fun setRetry(action:Action?){ retryCompletable = if (action == null) null else Completable.fromAction(action) }
}
