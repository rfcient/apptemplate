package com.example.apptemplet.domain.model

import com.example.apptemplet.db.entity.DataItem
import com.squareup.moshi.Json

class UserDataResponse {
    @Json(name = "data")
    var userData: DataItem? = null
}