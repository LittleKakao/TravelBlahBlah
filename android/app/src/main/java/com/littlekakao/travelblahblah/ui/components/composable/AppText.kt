package com.dbinc.uface.ui.components.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun TitleText(head:String) {
    Text(
        text = head,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun SubtitleText(item:String) {
    Text(
        text = item,
        fontWeight = FontWeight.SemiBold
    )
}