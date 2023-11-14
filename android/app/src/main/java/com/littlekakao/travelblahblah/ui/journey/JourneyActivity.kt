package com.littlekakao.travelblahblah.ui.journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.littlekakao.travelblahblah.ui.components.composable.BottomNavigation
import com.littlekakao.travelblahblah.ui.components.theme.TravelblahblahTheme


class JourneyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelblahblahTheme {
                // A surface container using the 'background' color from the theme
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
        Box(Modifier.padding(it)){
            JourneyNavigationGraph(navController = navController)
        }
    }
}

@Composable
fun JourneyBottomNavigation(navController: NavHostController) {
    val items = listOf<BottomNavigation>(
        JourneyViewModel.ListMenu,
        JourneyViewModel.CalendarMenu,
    )

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color(0xFF3F414E)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
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
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = Color.Gray,
                selected = currentRoute == item.screenRoute,
                alwaysShowLabel = false,
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
    NavHost(navController = navController, startDestination = JourneyViewModel.ListMenu.screenRoute) {
        composable(JourneyViewModel.CalendarMenu.screenRoute) {
            JourneyCalendarFragment()
        }
        composable(JourneyViewModel.ListMenu.screenRoute) {
            JourneyListFragment()
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