package com.example.retrofitpractise

import com.example.retrofitpractise.data.JsonData
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitServices {
    @GET("carts")
    suspend fun getAllCarts() : Response<JsonData>
}