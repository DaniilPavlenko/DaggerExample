package com.example.daggerexample

/**
 * Created by Daniil Pavlenko on 29.01.20.
 */
data class Car(val name: String) {
    fun printName() {
        println("Car name: $name")
    }
}