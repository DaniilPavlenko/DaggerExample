package com.example.daggerexample.network.auth

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
interface AuthApi {
    @GET
    fun getFake(): Call<ResponseBody>
}