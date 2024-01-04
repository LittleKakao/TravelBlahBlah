package com.littlekakao.travelblahblah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.littlekakao.travelblahblah.ui.journey.JOURNEY_ROUTE
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme
import com.littlekakao.travelblahblah.ui.journey.JourneyView


class TravelBlahBlah : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelblahblahTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TBBNavHost(navController = navController)
                }
            }
        }
    }
}


@Composable
fun TBBNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = JOURNEY_ROUTE) {
        composable(JOURNEY_ROUTE) {JourneyView()}
    }
}
