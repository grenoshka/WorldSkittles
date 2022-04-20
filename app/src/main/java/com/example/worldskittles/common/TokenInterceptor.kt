package com.example.worldskittles.common

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Bearer ${Token.accessToken}")
                .build()
        return chain.proceed(request)
    }
}