package com.example.worldskittles.common

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    val loggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    var okHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(TokenInterceptor())
            .build()
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("http://62.113.103.113/api/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var apiService = retrofit.create(ApiService::class.java)
}