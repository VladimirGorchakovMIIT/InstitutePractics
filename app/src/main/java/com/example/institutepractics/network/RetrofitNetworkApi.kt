package com.example.institutepractics.network

import com.example.institutepractics.models.Character
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitNetworkApi {
    @GET(value = "/characters")
    suspend fun getUsers(): List<Character>
}

private const val NETWORK_BASE_URL = "https://www.anapioficeandfire.com/api/characters"

class RetrofitNetwork : RetrofitNetworkApi {
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val networkApi: RetrofitNetworkApi by lazy {
        Retrofit.Builder()
            .baseUrl(NETWORK_BASE_URL)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(RetrofitNetworkApi::class.java)
    }

    override suspend fun getUsers(): List<Character> = networkApi.getUsers()
}