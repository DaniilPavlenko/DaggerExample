package com.example.daggerexample.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
data class User(
    @SerializedName("id")
    val id: Long,
    @SerializedName("username")
    val userName: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("website")
    val webSite: String
)