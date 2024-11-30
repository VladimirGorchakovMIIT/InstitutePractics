package com.example.institutepractics.models

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name: String,
    val culture: String? = null,
    val born: String? = null,
    val titles: List<String> = emptyList(),
    val aliases: List<String> = emptyList(),
    val playedBy: List<String> = emptyList()
)
