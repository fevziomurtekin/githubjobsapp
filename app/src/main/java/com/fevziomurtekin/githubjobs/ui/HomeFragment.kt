package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.fevziomurtekin.githubjobs.view.JobsViewModel
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.*
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

        btn_clear.setOnClickListener {
            StorageExt.removePref(context!!,KeywordExt.INTENT_ARGUMENT)
            Navigation.findNavController(view).navigate(R.id.action_settings)
        }

        initChips()
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
            chips.chipBackgroundColor = resources.getColorStateList(R.color.colorAccent)
            chips.chipCornerRadius = 15f
            chips.setTextColor(resources.getColor(android.R.color.white))
            chips.text = map[c]
            when(c){
                0->{
                    chips.chipIcon = resources.getDrawable(R.drawable.ic_location)
                    chips.chipIconTint = resources.getColorStateList(android.R.color.holo_red_dark)
                    chips.setOnCloseIconClickListener {

                    }
                }
                1->{
                    chips.chipIcon = resources.getDrawable(R.drawable.ic_description)
                    chips.chipIconTint = resources.getColorStateList(android.R.color.holo_green_light)
                    chips.setOnCloseIconClickListener {

                    }
                }
            }
            ll_chips.addView(chips)
            (chips.layoutParams as LinearLayout.LayoutParams).marginEnd = 5
        }

        if(map.isEmpty()){
            hsv_chips.visibility = View.GONE
            btn_clear.text = getString(R.string.add_location_destination)
        }
    }

    private fun initAdapter(){
        jobListAdapter = JobListAdapter({viewModel.retry()}, View.OnClickListener {
            val response = it.tag as JobsResponse
            Navigation.findNavController(view!!).navigate(R.id.action_detail, bundleOf(KeywordExt.INTENT_ARGUMENT to response))
        })
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
