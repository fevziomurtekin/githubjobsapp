package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.JobsResponse
import com.fevziomurtekin.githubjobs.data.KeywordExt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.details_fragment.*


class DetailsFragment : Fragment(){

    var response : JobsResponse?=null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        response = arguments?.getParcelable<JobsResponse>(KeywordExt.INTENT_ARGUMENT)
        return inflater.inflate(R.layout.details_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(response!=null) {
            Glide.with(context!!)
                    .load(response?.company_logo)
                    .into(iv_company_image)

            tv_toolbar.text = "${response?.title} - ${response?.company}"
            tv_job_date_details.text = response?.created_at
            tv_job_location_details.text = response?.location
            tv_job_type_details.text = response?.type

            tv_job_description_details.text = Html.fromHtml(response?.description)
            tv_how_to_job_apply_description.text = Html.fromHtml(response?.how_to_apply)
        }

    }
}