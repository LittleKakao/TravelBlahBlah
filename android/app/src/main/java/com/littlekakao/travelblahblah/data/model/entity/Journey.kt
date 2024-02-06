package com.littlekakao.travelblahblah.data.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Journey (
    val journeyId: Int = 0,
    val userId: Int = 0,
    val journeyName: String = "",
    val journeyDestination: String = "",
    val journeyStartDate: Date = Date(),
    val journeyEndDate: Date = Date(),
    val journeyCreateDate: Date = Date(),
    val journeyUpdateDate: Date = Date(),
    val journeyDeleteYn: String = ""
)