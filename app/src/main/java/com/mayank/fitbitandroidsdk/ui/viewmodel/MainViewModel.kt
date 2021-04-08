package com.mayank.fitbitandroidsdk.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayank.fitbitandroidsdk.data.model.*
import com.mayank.fitbitandroidsdk.data.repository.MainRepository
import com.mayank.fitbitandroidsdk.utils.Resource
import kotlinx.coroutines.launch

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private var oAuthCode = MutableLiveData<String>()
    private var mAccessToken = MutableLiveData<Resource<AccessToken>>()
    private var mUserProfile = MutableLiveData<Resource<UserProfile>>()
    private var mUserHeartActivity = MutableLiveData<Resource<HeartActivity>>()
    private var mUserActivity = MutableLiveData<Resource<UserActivity>>()

    fun setCode(code: String) {
        oAuthCode.postValue(code)
    }

    fun getAccessToken(
        authorization: String,
        clientID: String,
        grant_type: String,
        redirect_uri: String,
        code: String
    ): MutableLiveData<Resource<AccessToken>> {
        mAccessToken.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val response = Resource.success(
                    mainRepository.getAccessToken(
                        authorization,
                        clientID,
                        grant_type,
                        redirect_uri,
                        code
                    )
                )
                mAccessToken.postValue(response)
            } catch (e: Exception) {
                mAccessToken.postValue(Resource.error(e.message.toString(), null))
            }
        }
        return mAccessToken
    }

    fun getUserProfile(
        authorization: String,
        userID: String
    ): MutableLiveData<Resource<UserProfile>> {
        mUserProfile.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val response = mainRepository.getUserProfile(authorization, userID)
                mUserProfile.postValue(Resource.success(response))
            } catch (e: Exception) {
                mUserProfile.postValue(Resource.error(e.message.toString(), null))
            }
        }
        return mUserProfile
    }

    fun getUserHeartActivity(
        authorization: String,
        userID: String,
        date: String
    ): MutableLiveData<Resource<HeartActivity>> {
        viewModelScope.launch {
            mUserHeartActivity.postValue(Resource.loading(null))
            try {
                val response = mainRepository.getUserHeartActivities(authorization, userID, date)
                mUserHeartActivity.postValue(Resource.success(response))
            } catch (e: Exception) {
                mUserHeartActivity.postValue(Resource.error(e.message.toString(), null))
            }
        }
        return mUserHeartActivity
    }

    fun getUserActivity(
        authorization: String,
        userID: String,
        date: String
    ): MutableLiveData<Resource<UserActivity>> {
        mUserActivity.postValue(Resource.loading(null))
        viewModelScope.launch {
            try {
                val response = mainRepository.getUserActivities(authorization, userID, date)
                mUserActivity.postValue(Resource.success(response))
            } catch (e: Exception) {
                mUserActivity.postValue(Resource.error(e.message.toString(), null))
            }
        }
        return mUserActivity
    }


    fun getCode(): MutableLiveData<String> = oAuthCode


}