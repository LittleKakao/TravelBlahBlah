package com.littlekakao.travelblahblah.ui.journey

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.littlekakao.travelblahblah.R
import com.littlekakao.travelblahblah.ui.base.AppElevatedButton
import com.littlekakao.travelblahblah.ui.base.AppFloatingActionButton
import com.littlekakao.travelblahblah.ui.base.BottomNavigation
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme

const val JOURNEY_ROUTE: String = "journey"

object CalendarMenu : BottomNavigation(
    R.string.text_calendar,
    R.drawable.ic_round_calendar_month,
    "calendar"
)

object ListMenu : BottomNavigation(
    R.string.text_list,
    R.drawable.ic_round_list,
    "list"
)


@Composable
fun JourneyView() {
    val journeyNavController = rememberNavController()
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        JourneyNavHost(navController = journeyNavController)
    }

}


@Composable
fun JourneyBottomNavigation(navController: NavHostController) {
    val items = listOf(
        ListMenu,
        CalendarMenu
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
                            popUpTo(it) {
                                saveState = true
                                inclusive = true
                            }
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
fun JourneyNavHost(navController: NavHostController) {
    fun onClickRegister() {
        navController.navigate(JOURNEY_REGISTER_ROUTE) {
            popUpTo(ListMenu.screenRoute) { saveState = true }

            launchSingleTop = true
            restoreState = true
        }
    }

    NavHost(navController = navController, startDestination = ListMenu.screenRoute) {
        composable(JOURNEY_REGISTER_ROUTE) { JourneyRegisterView(navController) }
        composable(ListMenu.screenRoute) { JourneyList(onClickRegister = {onClickRegister()}, navController)}
        composable(CalendarMenu.screenRoute) { JourneyCalendar(onClickRegister = {onClickRegister()}, navController) }
    }
}


@Composable
fun JourneyList(onClickRegister: () -> Unit, navController: NavHostController) {
    Scaffold(
        bottomBar = { JourneyBottomNavigation(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            AppElevatedButton(
                label = stringResource(R.string.add_journey),
                onClick = onClickRegister
            )
        }
    }

}

@Composable
fun JourneyCalendar(onClickRegister: () -> Unit, navController: NavHostController) {
    Scaffold(
        bottomBar = { JourneyBottomNavigation(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        )
        {
            Spacer(Modifier.matchParentSize())
            AppFloatingActionButton(
                onClick = onClickRegister,
                icon = painterResource(R.drawable.ic_round_add),
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            )
            Text("Temp")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun JourneyPreview() {
    TravelblahblahTheme {
        JourneyView()
    }
}