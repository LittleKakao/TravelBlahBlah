package com.littlekakao.travelblahblah.ui.journey

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlekakao.travelblahblah.R
import com.littlekakao.travelblahblah.ui.base.AppElevatedButton
import com.littlekakao.travelblahblah.ui.base.BaseTextField
import com.littlekakao.travelblahblah.ui.base.BoldText
import com.littlekakao.travelblahblah.ui.base.ExtraBoldText
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme

const val JOURNEY_REGISTER_ROUTE: String = "registration"


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JourneyRegisterView(navController: NavHostController) {
    Scaffold(
        topBar = {JourneyRegisterTopAppBar(navController = navController)}
    )
    {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        )
        {
            JourneyRegisterScreen(navController = navController)
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun JourneyRegisterTopAppBar(navController: NavHostController) {
    CenterAlignedTopAppBar(
        title = {
            ExtraBoldText(stringResource(R.string.title_journey_register),28)
        },
        navigationIcon = {
            IconButton(onClick = {navController.popBackStack()}) {
                Icon(
                    painter = painterResource(R.drawable.ic_round_arrow_back),
                    contentDescription = stringResource(R.string.back)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
    )
}

@Composable
fun JourneyRegisterScreen(navController: NavHostController){
    var where by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }
    var travelName by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue("", TextRange(0, 7)))
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
        {
            Column{
                BoldText(stringResource(R.string.journey_register_where),20)
                BaseTextField(value = where, onValueChange = {where = it})
            }
        }
        Spacer(Modifier.height(100.dp))
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
        {
            Column{
                BoldText(stringResource(R.string.journey_register_travel_name),20)
                BaseTextField(value = travelName, onValueChange = {travelName = it})
            }
        }
        Spacer(Modifier.height(100.dp))
        Box(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.CenterHorizontally)
        )
        {
            AppElevatedButton(
                label = stringResource(R.string.journey_register),
                onClick = {navController.popBackStack()} // TODO: 여행 등록 후 리스트 이동
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JourneyRegisterPreview() {
    val navController = rememberNavController()

    TravelblahblahTheme {
        JourneyRegisterView(navController = navController)
    }
}