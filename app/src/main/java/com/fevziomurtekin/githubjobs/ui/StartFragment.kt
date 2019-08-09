package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fevziomurtekin.githubjobs.R
import kotlinx.android.synthetic.main.start_fragment.*
import timber.log.Timber

class StartFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("start fragment.")
        super.onViewCreated(view, savedInstanceState)

        tv_skip.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_start)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("start fragment.")
        super.onActivityCreated(savedInstanceState)
    }

}