package com.example.daggerexample.network.auth

import com.example.daggerexample.model.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
interface AuthApi {
    @GET("users/{id}")
    fun getUser(@Path("id") id: Long): Flowable<User>
}