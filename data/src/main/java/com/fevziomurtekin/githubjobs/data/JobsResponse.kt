package com.fevziomurtekin.githubjobs.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "jobs")
data class JobsResponse(
    @SerializedName("company")
    val company: String,
    @SerializedName("company_logo")
    val company_logo: String,
    @SerializedName("company_url")
    val company_url: String,
    @SerializedName("created_at")
    val created_at: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("how_to_apply")
    val how_to_apply: String,
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)