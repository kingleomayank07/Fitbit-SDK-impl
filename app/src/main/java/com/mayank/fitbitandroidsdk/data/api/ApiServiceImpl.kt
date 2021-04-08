package com.mayank.fitbitandroidsdk.data.api

import com.mayank.fitbitandroidsdk.data.api.RetrofitClient.mFitbitClient
import com.mayank.fitbitandroidsdk.data.model.AccessToken
import com.mayank.fitbitandroidsdk.data.model.HeartActivity
import com.mayank.fitbitandroidsdk.data.model.UserActivity
import com.mayank.fitbitandroidsdk.data.model.UserProfile


class ApiServiceImpl : ApiService {

    override suspend fun getProfile(
        authorization: String,
        clientId: String,
        grant_type: String,
        redirect_uri: String,
        code: String
    ): AccessToken {
        return mFitbitClient.getAccessToken(
            "application/x-www-form-urlencoded",
            authorization,
            clientId,
            grant_type,
            redirect_uri,
            code
        )
    }

    override suspend fun getUser(authorization: String, userID: String): UserProfile {
        return mFitbitClient.getUserProfile(authorization, id = userID)
    }

    override suspend fun getUserHeartActivity(
        authorization: String,
        userID: String,
        date: String
    ): HeartActivity {
        return mFitbitClient.getUserHeartActivity(authorization, userID, date)
    }

    override suspend fun getUserActivity(
        authorization: String,
        userID: String,
        date: String
    ): UserActivity {
        return mFitbitClient.getUserActivity(authorization, userID, date)
    }

}