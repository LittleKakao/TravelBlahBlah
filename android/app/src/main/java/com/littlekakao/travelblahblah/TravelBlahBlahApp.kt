package com.littlekakao.travelblahblah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme
import com.littlekakao.travelblahblah.ui.journey.JourneyScreen

class TravelBlahBlah : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelblahblahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JourneyScreen()
                }
            }
        }
    }
}