package com.odin.composesample.reservation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odin.composesample.application.DesignerLayout
import com.odin.composesample.reservation.views.BottomLayout
import com.odin.composesample.reservation.views.TopLayout

@Composable
fun ReservationHome() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
        topBar = { TopLayout() },
        content = { DesignerLayout() },
        bottomBar = { BottomLayout() }
    )
}

@Preview
@Composable
fun ShowViewHome() {
    ReservationHome()
}