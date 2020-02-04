package com.example.daggerexample.network.main

import com.example.daggerexample.model.Post
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Daniil Pavlenko on 04.02.20.
 */
interface MainApi {

    @GET("posts")
    fun getPostsFromUser(@Query("userId") userId: Long): Flowable<List<Post>>
}