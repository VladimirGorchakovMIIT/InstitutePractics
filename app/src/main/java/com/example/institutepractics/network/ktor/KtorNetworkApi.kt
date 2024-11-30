package com.example.institutepractics.network.ktor
import com.example.institutepractics.models.Character

interface KtorNetworkApi {
    suspend fun getCharacters(): List<Character>
}