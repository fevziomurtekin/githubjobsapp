package com.fevziomurtekin.githubjobs.data

import com.fevziomurtekin.githubjobs.data.JobsResponse

interface GithubjobsRepository{
    fun postsOfHobs(description:String,location:String,page:String):List<JobsResponse>
}