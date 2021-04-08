package com.mayank.fitbitandroidsdk.data.repository

import com.mayank.fitbitandroidsdk.data.api.ApiService
import com.mayank.fitbitandroidsdk.data.model.AccessToken
import com.mayank.fitbitandroidsdk.data.model.HeartActivity
import com.mayank.fitbitandroidsdk.data.model.UserActivity
import com.mayank.fitbitandroidsdk.data.model.UserProfile

class MainRepository(private val apiHelper: ApiService) {

    suspend fun getAccessToken(
        authorization: String,
        clientID: String,
        grant_type: String,
        redirect_uri: String,
        code: String
    ): AccessToken {
        return apiHelper.getProfile(authorization, clientID, grant_type, redirect_uri, code)
    }

    suspend fun getUserProfile(authorization: String, userID: String): UserProfile? {
        return apiHelper.getUser(authorization, userID)
    }

    suspend fun getUserHeartActivities(
        authorization: String,
        userID: String,
        date: String
    ): HeartActivity {
        return apiHelper.getUserHeartActivity(authorization, userID, date)
    }

    suspend fun getUserActivities(
        authorization: String,
        userID: String,
        date: String
    ): UserActivity {
        return apiHelper.getUserActivity(authorization, userID, date)
    }

}