package com.example.daggerexample.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
class User {
    @SerializedName("id")
    var id: Long = 0
    @SerializedName("username")
    var userName: String = ""
    @SerializedName("email")
    var email: String = ""
    @SerializedName("website")
    var webSite: String = ""
}