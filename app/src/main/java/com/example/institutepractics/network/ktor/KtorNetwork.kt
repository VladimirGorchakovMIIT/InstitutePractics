package com.example.institutepractics.network.ktor

import android.util.Log
import com.example.institutepractics.models.Character
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import kotlin.time.Duration.Companion.seconds

private const val NETWORK_BASE_URL = "www.anapioficeandfire.com"

class KtorNetwork : KtorNetworkApi {
    private val json = Json {
        isLenient = true
        ignoreUnknownKeys = true
    }

    private val client: HttpClient by lazy{
        HttpClient(engine = OkHttp.create()) {
            install(ContentNegotiation) { json(json) }

            install(HttpTimeout) {
                connectTimeoutMillis = 20.seconds.inWholeMilliseconds
                requestTimeoutMillis = 60.seconds.inWholeMilliseconds
                socketTimeoutMillis = 20.seconds.inWholeMilliseconds
            }

            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
        }
    }

    override suspend fun getCharacters(): List<Character> {
        return try {
            client.get {
                url {
                    host = NETWORK_BASE_URL
                    protocol = URLProtocol.HTTPS
                    contentType(ContentType.Application.Json)
                    path("api", "characters")
                    parameter("page", 5)
                    parameter("pageSize", "50")
                }
            }.let { response ->
                Log.d("Ktor Response", response.body())
                response.body()
            }

        } catch (exception: Exception) {
            Log.e("Error", exception.message.toString())
            listOf()
        }
    }
}