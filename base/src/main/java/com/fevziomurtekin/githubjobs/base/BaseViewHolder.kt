package com.fevziomurtekin.githubjobs.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fevziomurtekin.githubjobs.data.JobsResponse
import kotlinx.android.synthetic.main.jobs_item.view.*

class BaseViewHolder(view:View) : RecyclerView.ViewHolder(view){

    fun bind(response:JobsResponse?){
        if(response!=null){
            itemView.tv_job_title.text = response.title
            //TODO it'll change layout design.
        }
    }

    companion object{
        fun create(parent:ViewGroup):BaseViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.jobs_item,parent,false)
            return BaseViewHolder(view)
        }
    }

}