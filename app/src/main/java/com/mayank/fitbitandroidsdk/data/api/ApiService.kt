package com.mayank.fitbitandroidsdk.data.api

import com.mayank.fitbitandroidsdk.data.model.AccessToken
import com.mayank.fitbitandroidsdk.data.model.HeartActivity
import com.mayank.fitbitandroidsdk.data.model.UserActivity
import com.mayank.fitbitandroidsdk.data.model.UserProfile

interface ApiService {

    suspend fun getProfile(
        authorization: String,
        clientId: String,
        grant_type: String,
        redirect_uri: String,
        code: String
    ): AccessToken

    suspend fun getUser(authorization: String, userID: String): UserProfile?

    suspend fun getUserHeartActivity(
        authorization: String,
        userID: String,
        date: String
    ): HeartActivity

    suspend fun getUserActivity(
        authorization: String,
        userID: String,
        date: String
    ): UserActivity

}