package com.fevziomurtekin.githubjobs.data

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource

class JobDataFactory : DataSource.Factory<String,MutableList<JobsResponse>>{

   /* val mutableLiveData:MutableLiveData<JobDataSource>?= null
    val jobdataSource:JobDataSource?=null
    val baseApplication:Application?=null*/

    constructor(){

    }


    override fun create(): DataSource<String, MutableList<JobsResponse>> {


    }



}
