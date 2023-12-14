package com.littlekakao.travelblahblah.ui.journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.littlekakao.travelblahblah.R
import com.littlekakao.travelblahblah.ui.components.composable.AppElevatedButton
import com.littlekakao.travelblahblah.ui.components.composable.BottomNavigation
import com.littlekakao.travelblahblah.ui.components.theme.TravelblahblahTheme

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

class JourneyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelblahblahTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JourneyScreenView()
                }
            }
        }
    }
}

@Composable
fun JourneyScreenView() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { JourneyBottomNavigation(navController = navController)}
    ) {
        Box(
            modifier = Modifier.padding(it).fillMaxSize(),
            contentAlignment = Alignment.Center){

            AppElevatedButton(
                label = stringResource(R.string.add_journey),
                onClick = {} // TODO: 여행 등록 화면 이동
            )

            JourneyNavigationGraph(navController = navController)
        }
    }
}

@Composable
fun JourneyBottomNavigation(navController: NavHostController) {
    val items = listOf(
        CalendarMenu,
        ListMenu
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color(0xFF3F414E)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = stringResource(id = item.title),
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp)
                    )
                },
                label = { Text(stringResource(id = item.title), fontSize = 9.sp) },
                selected = currentRoute == item.screenRoute,
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(item.screenRoute) {
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun JourneyNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = LIST) {
        composable(LIST) {
            // TODO: LIST Compose 실행
        }
        composable(CALENDAR) {
            // TODO: CALENDAR Compose 실행
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JourneyPreview() {
    TravelblahblahTheme {
        JourneyScreenView()
    }
}