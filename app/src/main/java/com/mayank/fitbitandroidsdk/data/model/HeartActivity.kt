package com.mayank.fitbitandroidsdk.data.model

import com.google.gson.annotations.SerializedName

data class HeartActivity(

	@field:SerializedName("activities-heart")
	val activitiesHeart: List<ActivitiesHeartItem?>? = null
)

data class HeartRateZonesItem(

	@field:SerializedName("min")
	val min: Int? = null,

	@field:SerializedName("max")
	val max: Int? = null,

	@field:SerializedName("name")
	val name: String? = null
)

data class ActivitiesHeartItem(

	@field:SerializedName("dateTime")
	val dateTime: String? = null,

	@field:SerializedName("value")
	val value: Value? = null
)

data class Value(

	@field:SerializedName("customHeartRateZones")
	val customHeartRateZones: List<Any?>? = null,

	@field:SerializedName("heartRateZones")
	val heartRateZones: List<HeartRateZonesItem?>? = null
)
