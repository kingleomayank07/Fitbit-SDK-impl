package com.mayank.fitbitandroidsdk.ui.acitivity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.ViewModelProvider
import com.mayank.fitbitandroidsdk.R
import com.mayank.fitbitandroidsdk.data.api.ApiServiceImpl
import com.mayank.fitbitandroidsdk.utils.ViewModelFactory
import com.mayank.fitbitandroidsdk.ui.viewmodel.MainViewModel

class FitbitActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fitbit_activity)
        setUpViewModel()
        launchURL()
    }

    private fun setUpViewModel() {
        mainViewModel = ViewModelProvider(
            this,
            ViewModelFactory(ApiServiceImpl())
        ).get(MainViewModel::class.java)
    }

    private fun launchURL() {
        val authorizationUrl =
            "https://www.fitbit.com/oauth2/authorize?response_type=code&client_id=22CDDM&redirect_uri=myapp%3A%2F%2Flogincallback&scope=activity%20heartrate%20location%20nutrition%20profile%20settings%20sleep%20social%20weight&expires_in=604800"
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(
            this, Uri.parse(authorizationUrl)
        )
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val code = intent?.data?.getQueryParameter("code")
        if (code != null) {
            mainViewModel.setCode(code)
        }
    }

}
