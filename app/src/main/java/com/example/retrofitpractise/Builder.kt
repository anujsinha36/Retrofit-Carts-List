package com.example.retrofitpractise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class Builder {
    companion object{
        var retrofitServices : RetrofitServices?= null
        fun getInstance(): RetrofitServices{
            if (retrofitServices == null){
                retrofitServices = Retrofit.Builder().baseUrl("https://dummyjson.com").
                addConverterFactory(GsonConverterFactory.create()).
                build().
                create(RetrofitServices::class.java)
            }
            return retrofitServices!!
        }
    }
}