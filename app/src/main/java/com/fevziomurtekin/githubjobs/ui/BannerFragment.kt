package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.BannerData
import com.fevziomurtekin.githubjobs.data.JobDataRequest
import kotlinx.android.synthetic.main.banner_fragment.*
import timber.log.Timber

class BannerFragment(val position:Int,
                     val data: BannerData,
                     var jobDataRequest: JobDataRequest
) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.banner_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        iv_banner_image.setImageResource(data.image_resource)
        tv_banner_title.text = Html.fromHtml(data.title)

        when(position){
            0->{
                til_location_description.visibility = View.GONE
            }
            1->{
                til_location_description.hint = getString(R.string.enter_location)
                til_location_description.visibility = View.VISIBLE
                tev_location_description.addTextChangedListener {
                    Timber.d("location : ${it.toString()}")
                    jobDataRequest.location = it?.toString()!!
                }

            }
            2->{
                til_location_description.hint = getString(R.string.enter_job_title)
                til_location_description.visibility = View.VISIBLE

                tev_location_description.addTextChangedListener {
                    Timber.d("description : ${it.toString()}")
                    jobDataRequest.description = it?.toString()!!

                }


            }
        }
    }

}