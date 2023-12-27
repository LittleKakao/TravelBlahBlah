package com.littlekakao.travelblahblah.ui.base

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.littlekakao.travelblahblah.ui.theme.TravelblahblahTheme


@Composable
fun ExtraBoldText(
    text:String,
    fontSize:Int = 16,
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.ExtraBold,
    )
}

@Composable
fun BoldText(
    text:String,
    fontSize:Int = 16,
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun SemiBoldText(
    text:String,
    fontSize:Int = 16,
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.SemiBold
    )
}


@Preview
@Composable
fun PreviewText(){
    TravelblahblahTheme {
        Column{
            ExtraBoldText(text = "ExtraBold")
            BoldText(text = "Bold")
            SemiBoldText(text = "SemiBold")
        }
    }
}