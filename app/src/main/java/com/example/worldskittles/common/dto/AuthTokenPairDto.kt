package com.example.worldskittles.common.dto

data class AuthTokenPairDto(
    val accessToken: AuthToken,
    val refreshToken: AuthToken,
)