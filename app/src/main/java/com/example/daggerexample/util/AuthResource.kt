package com.example.daggerexample.util

/**
 * Created by Daniil Pavlenko on 01.02.20.
 */
sealed class AuthResource<out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : AuthResource<T>(data)
    class Loading<T>(data: T? = null) : AuthResource<T>(data)
    class Error<T>(message: String, data: T? = null) : AuthResource<T>(data, message)
    class LogOut<T>(data: T? = null) : AuthResource<T>(data)
}