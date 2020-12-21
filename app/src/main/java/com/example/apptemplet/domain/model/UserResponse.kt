package com.example.apptemplet.domain.model

import android.os.Parcelable
import com.example.apptemplet.db.entity.DataItem
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserResponse(

	@Json(name="per_page")
	val perPage: Int? = null,

	@Json(name="total")
	val total: Int? = null,

	@Json(name="ad")
	val ad: Ad? = null,

	@Json(name="data")
	var userList: List<DataItem?>? = null,

	@Json(name="page")
	val page: Int? = null,

	@Json(name="total_pages")
	val totalPages: Int? = null
) : Parcelable

@Parcelize
data class Ad(

	@Json(name="company")
	val company: String? = null,

	@Json(name="text")
	val text: String? = null,

	@Json(name="url")
	val url: String? = null
) : Parcelable


