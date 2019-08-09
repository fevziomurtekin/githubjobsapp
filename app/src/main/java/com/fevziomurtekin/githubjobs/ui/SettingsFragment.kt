package com.fevziomurtekin.githubjobs.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.fevziomurtekin.githubjobs.R
import com.fevziomurtekin.githubjobs.data.BannerData
import com.fevziomurtekin.githubjobs.data.JobDataRequest
import com.fevziomurtekin.githubjobs.data.KeywordExt
import com.fevziomurtekin.githubjobs.data.StorageExt
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.start_fragment.*
import timber.log.Timber

class SettingsFragment : Fragment(){

    private var questions:MutableList<BannerData>? = null
    private var jobDataRequest:JobDataRequest= JobDataRequest("","")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.start_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Timber.d("start fragment.")
        super.onViewCreated(view, savedInstanceState)
        tv_skip.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_home, bundleOf(KeywordExt.INTENT_ARGUMENT to jobDataRequest))
        }
        btn_done.setOnClickListener {
            StorageExt.savePref(context!!,KeywordExt.INTENT_ARGUMENT,GsonBuilder().create().toJson(jobDataRequest))
            Navigation.findNavController(view).navigate(R.id.action_home, bundleOf(KeywordExt.INTENT_ARGUMENT to jobDataRequest))
        }
        btn_forward.setOnClickListener {
           if((vp_banners.adapter as BannerAdapter).count>vp_banners.currentItem+1)
               vp_banners.currentItem = vp_banners.currentItem+1
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Timber.d("start fragment.")
        super.onActivityCreated(savedInstanceState)
        questions = mutableListOf(
            BannerData(getString(R.string.hellothere_message),R.drawable.githubjobs),
            BannerData(getString(R.string.which_location),R.drawable.location),
            BannerData(getString(R.string.what_defination),R.drawable.description)
        )

        vp_banners.adapter = BannerAdapter(childFragmentManager,questions!!,jobDataRequest)
        tl_indicator.setupWithViewPager(vp_banners)
        vp_banners.addOnPageChangeListener(object:ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0,1->{
                        btn_forward.visibility = View.VISIBLE
                        btn_done.visibility = View.GONE
                    }
                    2->{
                        btn_forward.visibility = View.GONE
                        btn_done.visibility = View.VISIBLE
                    }
                }
            }

        })
    }

}

class BannerAdapter(childFragmentManager: FragmentManager,
                       val questions: MutableList<BannerData>,
                       val jobDataRequest: JobDataRequest)
    : FragmentPagerAdapter(childFragmentManager) {
    override fun getItem(position: Int): Fragment = BannerFragment(position,questions[position],jobDataRequest)

    override fun getCount(): Int = questions.size
}

