package com.littlekakao.travelblahblah.ui.base

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun BoldText(head:String) {
    Text(
        text = head,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun SemiBoldText(item:String) {
    Text(
        text = item,
        fontWeight = FontWeight.SemiBold
    )
}