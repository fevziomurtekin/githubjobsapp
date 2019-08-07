package com.fevziomurtekin.githubjobs.data

import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import timber.log.Timber

interface GithubjobsApi {

    @GET("positions.json")
    fun getJobs(@Query("description") descriptions:String,
                @Query("location") location:String):Call<ListingResponse>

    @GET("positions.json")
    fun getJobsAfter(@Query("page") page:Long,
                @Query("description") descriptions:String,
                @Query("location") location:String):Call<ListingResponse>


    class ListingResponse(val data: ListingData)

    class ListingData(
        val children: List<JobChildrenResponse>,
        val after: String?,
        val before: String?
    )

    class JobChildrenResponse(val data:JobsResponse)

    companion object{
        private const val BASE_URL = "https://jobs.github.com/"
        fun create(): GithubjobsApi =
            create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl:HttpUrl): GithubjobsApi {
            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Timber.d(it)
            })
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GithubjobsApi::class.java)
        }

    }
}