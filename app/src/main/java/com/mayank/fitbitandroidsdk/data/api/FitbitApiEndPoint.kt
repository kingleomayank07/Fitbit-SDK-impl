package com.mayank.fitbitandroidsdk.data.api

import com.mayank.fitbitandroidsdk.data.model.AccessToken
import com.mayank.fitbitandroidsdk.data.model.HeartActivity
import com.mayank.fitbitandroidsdk.data.model.UserActivity
import com.mayank.fitbitandroidsdk.data.model.UserProfile
import retrofit2.http.*

interface FitbitApiEndPoint {

    @FormUrlEncoded
    @POST("oauth2/token")
    suspend fun getAccessToken(
        @Header("Content-Type") content_type: String,
        @Header("Authorization") authorization: String,
        @Field("clientId") clientId: String,
        @Field("grant_type") grant_type: String,
        @Field("redirect_uri") redirect_uri: String,
        @Field("code") code: String
    ): AccessToken

    @GET("1/user/{id}/profile.json")
    suspend fun getUserProfile(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): UserProfile

    @GET("1/user/{id}/activities/heart/date/{date}/7d.json")
    suspend fun getUserHeartActivity(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Path("date") date: String
    ): HeartActivity

    @GET("1/user/{id}/activities/date/{date}.json")
    suspend fun getUserActivity(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Path("date") date: String
    ): UserActivity

}
