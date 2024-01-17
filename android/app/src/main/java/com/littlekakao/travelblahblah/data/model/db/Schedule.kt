package com.littlekakao.travelblahblah.data.model.db

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Schedule (
    val scheduleId: Int = 0,
    val journeyId: Int = 0,
    val scheduleName: String = "",
    val scheduleDestination: String = "",
    val scheduleStartDate: Date = Date(),
    val scheduleEndDate: Date = Date(),
    val scheduleMemo: String = "",
    val categoryName: String = "",
    val categoryColor: String = "",
    val scheduleCreateDate: Date = Date(),
    val scheduleUpdateDate: Date = Date(),
    val scheduleDeleteYn: String = ""
)