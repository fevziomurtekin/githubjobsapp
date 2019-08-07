package com.fevziomurtekin.githubjobs.data

import android.app.usage.NetworkStats
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import retrofit2.Call
import retrofit2.Response
import java.util.concurrent.Executor

class PageKeyedJobsDataSource(
    private val githubjobsApi: GithubjobsApi,
    private val retryExecutor: Executor,
    private val location:String,
    private val description:String) : PageKeyedDataSource<String,JobsResponse>(){

    private var retry: (() -> Any)?=null

    val networkState = MutableLiveData<NetworkState>()

    val initialLoad = MutableLiveData<NetworkState>()

    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
        prevRetry?.let {
            retryExecutor.execute{
                it.invoke()
            }
        }
    }

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, JobsResponse>) {
        val request = githubjobsApi.getJobs(
            description,
            location
        )
        networkState.postValue(NetworkState.LOADING)
        initialLoad.postValue(NetworkState.LOADING)

        try{
            val response = request.execute()
            val data = response.body()?.data
            val items = data?.children?.map { it.data } ?: emptyList()
            retry = null
            networkState.postValue(NetworkState.LOADED)
            initialLoad.postValue(NetworkState.LOADED)
            callback.onResult(items,data?.before,data?.after)
        }catch (e:Exception){
            retry = {
                loadInitial(params, callback)
            }
            val error = NetworkState.error(e.message ?: "unknown error")
            networkState.postValue(error)
            initialLoad.postValue(error)
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, JobsResponse>) {
        networkState.postValue(NetworkState.LOADING)
        githubjobsApi.getJobsAfter(params.key.toLong(),
                location,
                description
            ).enqueue(
            object : retrofit2.Callback<GithubjobsApi.ListingResponse>{
                override fun onFailure(call: Call<GithubjobsApi.ListingResponse>, t: Throwable) {
                    retry = {
                        loadAfter(params, callback)
                    }
                    networkState.postValue(NetworkState.error(t.message ?: "unknown err"))
                }

                override fun onResponse(
                    call: Call<GithubjobsApi.ListingResponse>,
                    response: Response<GithubjobsApi.ListingResponse>
                ) {
                    if(response.isSuccessful){
                        val data = response.body()?.data
                        val items = data?.children?.map { it.data } ?: emptyList()
                        retry = null
                        callback.onResult(items,data?.after)
                        networkState.postValue(NetworkState.LOADED)
                    }else{
                        retry = {
                            loadAfter(params, callback)
                        }
                        networkState.postValue(
                            NetworkState.error("error code: ${response.code()}"))
                    }
                }

            }
        )
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, JobsResponse>) {
        // ignored, since we only ever append to our initial load
    }


}