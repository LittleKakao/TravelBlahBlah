package com.littlekakao.travelblahblah.utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

const val SERVER_IP: String = "15.165.184.182"
const val SERVER_PORT: Int = 8080


suspend fun get(vararg url: String, userId: Int? = null) {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get {
        url {
            protocol = URLProtocol.HTTP
            host = SERVER_IP
            port = SERVER_PORT
            appendPathSegments(*url)

            if (userId != null) {
                fragment = userId.toString()
            }
        }
    }
}

suspend fun post(vararg url: String, body: Any) {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.post {
        url {
            protocol = URLProtocol.HTTP
            host = SERVER_IP
            port = SERVER_PORT
            appendPathSegments(*url)
        }
        contentType(ContentType.Application.Json)
        setBody(body)
    }
}