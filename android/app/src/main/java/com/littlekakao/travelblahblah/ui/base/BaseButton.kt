package com.littlekakao.travelblahblah.ui.base

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.littlekakao.travelblahblah.R
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme

@Composable
fun AppElevatedButton(label:String, onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        SemiBoldText(label)
    }
}


@Composable
fun AppFloatingActionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: Painter,
    contentDescription: String? = null
    ){
    FloatingActionButton(
        onClick = { onClick() },
        shape = CircleShape,
        modifier = modifier
        ) {
        Icon(icon, contentDescription = contentDescription)
    }
}


@Preview
@Composable
fun PreviewFloatingActionButton(){
    TravelblahblahTheme {
        AppFloatingActionButton(onClick = {}, icon = painterResource(R.drawable.ic_round_add))
    }
}


@Preview
@Composable
fun PreviewElevatedButton(){
    TravelblahblahTheme {
        AppElevatedButton("Elevated", onClick = {})
    }
}