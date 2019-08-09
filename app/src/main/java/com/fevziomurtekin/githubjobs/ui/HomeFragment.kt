package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.KeywordExt
import com.fevziomurtekin.githubjobs.data.StorageExt

class HomeFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        StorageExt.getPref(context!!,KeywordExt.INTENT_ARGUMENT).let {
            if(it.isNullOrEmpty()) Navigation.findNavController(view).navigate(R.id.action_settings)
        }
    }
}
