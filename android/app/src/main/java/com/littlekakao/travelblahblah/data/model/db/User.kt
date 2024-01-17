package com.littlekakao.travelblahblah.data.model.db

import kotlinx.serialization.Serializable

@Serializable
data class User (
    val userId: Int = 0,
    val userName: String = "",
    val userDelYn: String = ""
)
