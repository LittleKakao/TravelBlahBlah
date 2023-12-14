package com.littlekakao.travelblahblah.ui.components.composable

import androidx.compose.material3.ElevatedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dbinc.uface.ui.components.composable.SubtitleText
import com.littlekakao.travelblahblah.ui.components.theme.TravelblahblahTheme

@Composable
fun AppElevatedButton(label:String, onClick: () -> Unit) {
    ElevatedButton(onClick = { onClick() }) {
        SubtitleText(label)
    }
}

@Preview
@Composable
fun PreviewElevatedButton(){
    TravelblahblahTheme {
        AppElevatedButton("Elevated", onClick = {})
    }
}