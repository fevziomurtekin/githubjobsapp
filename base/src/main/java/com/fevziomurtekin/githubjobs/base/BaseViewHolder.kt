package com.fevziomurtekin.githubjobs.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fevziomurtekin.githubjobs.data.JobsResponse
import kotlinx.android.synthetic.main.jobs_item.view.*

class BaseViewHolder(view:View) : RecyclerView.ViewHolder(view){

    fun bind(response:JobsResponse?,onClickListener:View.OnClickListener){
        try {
            if (response != null) {
                itemView.tv_job_company.text = response.company
                itemView.tv_job_location.text = response.location
                itemView.tv_job_type.text = response.type
                itemView.tv_job_title.text = response.title
                Glide.with(itemView)
                    .load(response.company_logo)
                    .into(itemView.iv_job_item)

                itemView.setOnClickListener(onClickListener)
                itemView.tag = response
            }
        }catch (e:Exception){}
    }

    companion object{
        fun create(parent:ViewGroup):BaseViewHolder{
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.jobs_item,parent,false)
            return BaseViewHolder(view)
        }
    }

}