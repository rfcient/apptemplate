package com.example.apptemplet.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize


@Parcelize
@Entity(tableName = "Employee")
data class DataItem(

    @ColumnInfo(name = "lastName")
    @Json(name="last_name")
    var lastName: String? = null,

    @Json(name="id")
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Id")
    val id: Int? = null,

    @ColumnInfo(name = "avatar")
    @Json(name="avatar")
    val avatar: String? = null,

    @ColumnInfo(name = "firstName")
    @Json(name="first_name")
    var firstName: String? = null,

    @ColumnInfo(name = "email")
    @Json(name="email")
    var email: String? = null
) : Parcelable