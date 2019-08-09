package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fevziomurtekin.githubjobs.JobsViewModel
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.JobDataRequest
import com.fevziomurtekin.githubjobs.data.KeywordExt
import com.fevziomurtekin.githubjobs.data.Status
import com.fevziomurtekin.githubjobs.data.StorageExt
import com.google.android.material.chip.Chip
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.home_fragment.*
import org.koin.android.architecture.ext.viewModel

class HomeFragment : Fragment() {

    val viewModel by viewModel<JobsViewModel>()
    var jobDataRequest:JobDataRequest?=null
    private lateinit var jobListAdapter:JobListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        StorageExt.getPref(context!!,KeywordExt.INTENT_ARGUMENT).let {
            if(it.isNullOrEmpty()) Navigation.findNavController(view).navigate(R.id.action_settings)
            else jobDataRequest = GsonBuilder().create().fromJson(it,JobDataRequest::class.java)
        }

        //TODO will be fixing bugs
        //initChips()
        initAdapter()
        initState()
    }

    private fun initChips(){
        val map = mutableMapOf<Int,String>()
        jobDataRequest?.let {
            if(it.description!="")
                map[1] = it.description
            if(it.location!="")
                map[0] = it.location
        }

        map.keys.forEach { c->
            val chips = Chip(context)
            chips.chipBackgroundColor = resources.getColorStateList(android.R.color.darker_gray)
            chips.chipCornerRadius = 7.5f
            chips.chipText = map[c]
            when(c){
                0->{
                    chips.chipIcon = resources.getDrawable(R.drawable.ic_location)
                }
                1->{
                    chips.chipIcon = resources.getDrawable(R.drawable.ic_description)
                }
            }
            ll_chips.addView(chips)
        }
    }

    private fun initAdapter(){
        jobListAdapter = JobListAdapter { viewModel.retry() }
        rv_jobs.adapter = jobListAdapter
        viewModel.jobList.observe(this, Observer {
            jobListAdapter.submitList(it)
        })
    }

    private fun initState(){
        viewModel.getState().observe(this, Observer {state->
            progresbar.visibility = if(viewModel.listIsEmpty() && state == Status.LOADING) View.VISIBLE else View.GONE
            if(!viewModel.listIsEmpty()){
                jobListAdapter.setState(state ?: Status.SUCCESS)
            }
        })
    }
}
