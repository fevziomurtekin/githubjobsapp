package com.fevziomurtekin.githubjobs.data

import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import timber.log.Timber

interface NetworkService {

    @GET("positions.json")
    fun getJobs(@Query("page") page:Int,
                @Query("loadSize") loadSize:Int,
                @Query("description") descriptions:String,
                @Query("location") location:String):Single<List<JobsResponse>>



    companion object{
        private const val BASE_URL = "https://jobs.github.com/"
        fun create(): NetworkService =
            create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl:HttpUrl): NetworkService {
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
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
        }

    }
}