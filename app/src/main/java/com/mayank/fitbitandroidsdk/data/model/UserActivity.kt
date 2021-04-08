package com.mayank.fitbitandroidsdk.data.model

import com.google.gson.annotations.SerializedName

data class UserActivity(

	@field:SerializedName("summary")
	val summary: Summary? = null,

	@field:SerializedName("activities")
	val activities: List<Any?>? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)

data class Summary(

	@field:SerializedName("distances")
	val distances: List<DistancesItem?>? = null,

	@field:SerializedName("fairlyActiveMinutes")
	val fairlyActiveMinutes: Int? = null,

	@field:SerializedName("lightlyActiveMinutes")
	val lightlyActiveMinutes: Int? = null,

	@field:SerializedName("activityCalories")
	val activityCalories: Int? = null,

	@field:SerializedName("caloriesOut")
	val caloriesOut: Int? = null,

	@field:SerializedName("activeScore")
	val activeScore: Int? = null,

	@field:SerializedName("marginalCalories")
	val marginalCalories: Int? = null,

	@field:SerializedName("steps")
	val steps: Int? = null,

	@field:SerializedName("veryActiveMinutes")
	val veryActiveMinutes: Int? = null,

	@field:SerializedName("caloriesBMR")
	val caloriesBMR: Int? = null,

	@field:SerializedName("sedentaryMinutes")
	val sedentaryMinutes: Int? = null
)

data class Goals(

	@field:SerializedName("distance")
	val distance: Double? = null,

	@field:SerializedName("activeMinutes")
	val activeMinutes: Int? = null,

	@field:SerializedName("caloriesOut")
	val caloriesOut: Int? = null,

	@field:SerializedName("steps")
	val steps: Int? = null
)

data class DistancesItem(

	@field:SerializedName("activity")
	val activity: String? = null,

	@field:SerializedName("distance")
	val distance: Int? = null
)
