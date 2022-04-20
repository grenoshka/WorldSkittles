package com.example.worldskittles.common

import com.example.worldskittles.common.dto.AuthTokenPairDto
import com.example.worldskittles.common.dto.Game
import com.example.worldskittles.common.dto.LoginBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("games")
    suspend fun getGames(): List<Game>

    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): AuthTokenPairDto
}