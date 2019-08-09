package com.fevziomurtekin.githubjobs.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JobDataRequest(
    var location:String="",
    var description:String=""
):Parcelable