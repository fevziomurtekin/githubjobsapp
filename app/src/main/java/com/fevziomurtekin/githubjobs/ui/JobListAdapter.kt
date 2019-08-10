package com.fevziomurtekin.githubjobs.ui

import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fevziomurtekin.githubjobs.base.BaseViewHolder
import com.fevziomurtekin.githubjobs.data.JobsResponse
import com.fevziomurtekin.githubjobs.data.Status

class JobListAdapter (private val retry: () -> Unit,
                      val onClickListener: View.OnClickListener)
    :PagedListAdapter<JobsResponse,RecyclerView.ViewHolder>(jobDiffCallback){

    private var state = Status.LOADING

    companion object{
        val jobDiffCallback = object :DiffUtil.ItemCallback<JobsResponse>(){
            override fun areItemsTheSame(oldItem: JobsResponse, newItem: JobsResponse): Boolean = oldItem.title == newItem.title

            override fun areContentsTheSame(oldItem: JobsResponse, newItem: JobsResponse): Boolean = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BaseViewHolder.create(parent)
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            (holder as BaseViewHolder).bind(getItem(position),onClickListener)
        }catch (e:Exception){}

    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasFooter()) 1 else 0
    }

    private fun hasFooter(): Boolean {
        return super.getItemCount() != 0 && (state == Status.LOADING || state == Status.ERROR)
    }

    fun setState(state:Status){
        this.state = state
        notifyItemChanged(super.getItemCount())

    }
}