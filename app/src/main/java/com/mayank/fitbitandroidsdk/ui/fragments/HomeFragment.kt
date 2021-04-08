package com.mayank.fitbitandroidsdk.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.mayank.fitbitandroidsdk.R
import com.mayank.fitbitandroidsdk.data.api.ApiServiceImpl
import com.mayank.fitbitandroidsdk.data.model.HeartActivity
import com.mayank.fitbitandroidsdk.data.model.UserActivity
import com.mayank.fitbitandroidsdk.data.model.UserProfile
import com.mayank.fitbitandroidsdk.utils.Resource
import com.mayank.fitbitandroidsdk.utils.Status
import com.mayank.fitbitandroidsdk.utils.ViewModelFactory
import com.mayank.fitbitandroidsdk.ui.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_home.*

const val bearer = "Bearer"
const val authorization = "Basic MjJDRERNOmRlZjIwZjFmZTVlMDBkMWUzNjJlZTA4NDM2MTQ5ZmI3"
const val clientID = "22CDDM"
const val grant_type = "authorization_code"
const val redirect_uri = "myapp://logincallback"
const val heartRate = "Heart Rate from SDK"

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var mainViewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()
        getOAuthCode()

    }

    private fun getOAuthCode() {
        mainViewModel.getCode().observe(viewLifecycleOwner, {
            if (it != null) {
                Log.d("TAG", "getOAuthCode: $it")
                val accessTokenObserver = mainViewModel.getAccessToken(
                    authorization,
                    clientID,
                    grant_type,
                    redirect_uri,
                    code = it
                )
                accessTokenObserver.observe(viewLifecycleOwner, { accessToken ->
                    when (accessToken.status) {
                        Status.LOADING -> {
                            pg.visibility = View.VISIBLE
                        }
                        Status.SUCCESS -> {
                            pg.visibility = View.GONE
                            val userProfileObserver = mainViewModel.getUserProfile(
                                accessToken.data?.accessToken?.prependIndent("$bearer ") ?: "",
                                accessToken.data?.userId ?: ""
                            )
                            val heartActivityObserver = mainViewModel.getUserHeartActivity(
                                accessToken.data?.accessToken?.prependIndent("$bearer ") ?: "",
                                accessToken.data?.userId ?: "",
                                "2021-04-07"
                            )
                            val userActivityObserver = mainViewModel.getUserActivity(
                                accessToken.data?.accessToken?.prependIndent("$bearer ") ?: "",
                                accessToken.data?.userId ?: "",
                                "2021-04-07"
                            )
                            setUI(
                                userProfileObserver,
                                heartActivityObserver,
                                userActivityObserver
                            )
                        }
                        Status.ERROR -> {
                            pg.visibility = View.GONE
                            Toast.makeText(
                                requireContext(),
                                "Unexpected error occurred!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        else -> {
                            pg.visibility = View.GONE
                            Toast.makeText(
                                requireContext(),
                                "Unexpected error occurred!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                })
            }
        })
    }

    private fun setUI(
        userProfileObserver: MutableLiveData<Resource<UserProfile>>,
        heartActivityObserver: MutableLiveData<Resource<HeartActivity>>,
        userActivityObserver: MutableLiveData<Resource<UserActivity>>
    ) {
        userProfileObserver.observe(viewLifecycleOwner, {
            username.text =
                it.data?.user?.firstName.plus(" ${it.data?.user?.lastName}")
            age.text = it.data?.user?.age.toString()
        })
        heartActivityObserver.observe(viewLifecycleOwner, {
            heart_data.text = heartRate
                .plus(
                    " max : ${
                        it.data?.activitiesHeart?.get(0)?.value?.heartRateZones?.get(
                            0
                        )?.max
                    }"
                ).plus(
                    " min : ${
                        it.data?.activitiesHeart?.get(0)?.value?.heartRateZones?.get(
                            0
                        )?.min
                    }"
                )

        })
        userActivityObserver.observe(viewLifecycleOwner, {
            goals.text = it.data?.goals.toString()
        })
    }

    private fun setUpViewModel() = requireActivity().let {
        mainViewModel = ViewModelProvider(it, ViewModelFactory(ApiServiceImpl()))
            .get(MainViewModel::class.java)
    }


}