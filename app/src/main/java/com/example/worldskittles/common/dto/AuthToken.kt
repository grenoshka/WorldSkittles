package com.example.worldskittles.common.dto

data class AuthToken(
    val token: String,
    val expiresIn: Int
)
