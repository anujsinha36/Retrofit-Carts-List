package com.example.retrofitpractise

class Repo(
    private val retrofitServices: RetrofitServices
) {
    suspend fun getAllCartsFromAPI() = retrofitServices.getAllCarts()
}