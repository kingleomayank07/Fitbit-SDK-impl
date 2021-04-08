package com.mayank.fitbitandroidsdk.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AccessToken(
	@SerializedName("access_token")
	@Expose
	val accessToken: String? = null,
	@SerializedName("refresh_token")
	@Expose
	val refreshToken: String? = null,
	@SerializedName("user_id")
	@Expose
	val userId: String? = null,
	@SerializedName("scope")
	@Expose
	val scope: String? = null,
	@SerializedName("token_type")
	@Expose
	val tokenType: String? = null,
	@SerializedName("expires_in")
	@Expose
	val expiresIn: Int? = null
)

