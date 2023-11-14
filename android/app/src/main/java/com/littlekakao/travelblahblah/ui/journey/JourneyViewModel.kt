package com.littlekakao.travelblahblah.ui.journey

import com.littlekakao.travelblahblah.R
import com.littlekakao.travelblahblah.ui.components.composable.BottomNavigation

class JourneyViewModel {
    object CalendarMenu : BottomNavigation(
        R.string.text_calendar,
        R.drawable.ic_round_calendar_month,
        CALENDAR
    )

    object ListMenu : BottomNavigation(
        R.string.text_list,
        R.drawable.ic_round_list,
        LIST
    )
}