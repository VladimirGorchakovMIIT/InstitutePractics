package com.example.institutepractics.models

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val name:String? = null,
    val culture:String? = null)
