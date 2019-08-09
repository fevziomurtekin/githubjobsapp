package com.fevziomurtekin.githubjobs.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BannerData(
    var title:String="",
    var image_resource:Int=0
):Parcelable