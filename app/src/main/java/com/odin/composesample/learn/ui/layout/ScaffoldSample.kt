package com.odin.composesample.learn.ui.layout

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class ScaffoldSample {

    private val topBarColor = Color.Green
    private val bottomColor = Color.Cyan

    @Preview
    @Composable
    fun ScaffoldDemo() {
        Scaffold(
            topBar = { ShowTopBar() },
            floatingActionButton = { ShowFloating() },
            drawerContent = { ShowTextView("drawer") },
            content = { ShowTextView("content") },
            bottomBar = { ShowBottomBar() }
        )
    }

    @Composable
    fun ShowTextView(value: String) = Text(text = value)

    @Composable
    fun ShowTopBar() = TopAppBar(
        title = {
            ShowTextView("top")
        },
        backgroundColor = topBarColor
    )

    @Composable
    fun ShowFloating() = FloatingActionButton(
        onClick = {}
    ) {
        ShowTextView("+")
    }

    @Composable
    fun ShowBottomBar() = BottomAppBar(backgroundColor = bottomColor) {
        ShowTextView("BottomAppBar")
    }

}