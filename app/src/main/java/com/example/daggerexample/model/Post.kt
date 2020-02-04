package com.example.daggerexample.model

import com.google.gson.annotations.SerializedName

/**
 * @author Daniil Pavlenko on 04.02.20.
 */
class Post {
    @SerializedName("userId")
    var userId: Long = 0
    @SerializedName("id")
    var id: Long = 0
    @SerializedName("title")
    lateinit var title: String
    @SerializedName("body")
    lateinit var body: String
}