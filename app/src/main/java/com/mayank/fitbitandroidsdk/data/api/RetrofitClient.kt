package com.mayank.fitbitandroidsdk.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL: String = "https://api.fitbit.com/"

    val mFitbitClient: FitbitApiEndPoint by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(FitbitApiEndPoint::class.java)
    }
}