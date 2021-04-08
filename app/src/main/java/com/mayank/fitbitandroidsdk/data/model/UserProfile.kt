package com.mayank.fitbitandroidsdk.data.model

data class UserProfile(
	val user: User? = null
)

data class User(
	val distanceUnit: String? = null,
	val lastName: String? = null,
	val gender: String? = null,
	val displayName: String? = null,
	val timezone: String? = null,
	val waterUnit: String? = null,
	val sdkDeveloper: Boolean? = null,
	val avatar640: String? = null,
	val clockTimeDisplayFormat: String? = null,
	val displayNameSetting: String? = null,
	val locale: String? = null,
	val offsetFromUTCMillis: Int? = null,
	val foodsLocale: String? = null,
	val strideLengthRunningType: String? = null,
	val features: Features? = null,
	val memberSince: String? = null,
	val waterUnitName: String? = null,
	val mfaEnabled: Boolean? = null,
	val heightUnit: String? = null,
	val isChild: Boolean? = null,
	val height: Double? = null,
	val isCoach: Boolean? = null,
	val strideLengthWalking: Double? = null,
	val avatar150: String? = null,
	val topBadges: List<Any?>? = null,
	val isBugReportEnabled: Boolean? = null,
	val strideLengthRunning: Double? = null,
	val languageLocale: String? = null,
	val sleepTracking: String? = null,
	val fullName: String? = null,
	val weight: Double? = null,
	val dateOfBirth: String? = null,
	val avatar: String? = null,
	val encodedId: String? = null,
	val swimUnit: String? = null,
	val startDayOfWeek: String? = null,
	val firstName: String? = null,
	val glucoseUnit: String? = null,
	val corporate: Boolean? = null,
	val challengesBeta: Boolean? = null,
	val legalTermsAcceptRequired: Boolean? = null,
	val ambassador: Boolean? = null,
	val strideLengthWalkingType: String? = null,
	val corporateAdmin: Boolean? = null,
	val averageDailySteps: Int? = null,
	val age: Int? = null,
	val weightUnit: String? = null
)

data class Features(
	val exerciseGoal: Boolean? = null
)

