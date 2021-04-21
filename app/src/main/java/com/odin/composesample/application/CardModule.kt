package com.odin.composesample.application

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.odin.composesample.theme.purple

private val tmpData = arrayListOf<ReservationData>(
    ReservationData(0, "title0", "contents1", false),
    ReservationData(1, "title1", "contents2", false),
    ReservationData(2, "title2", "contents3", false),
    ReservationData(3, "title3", "contents4", false),
    ReservationData(4, "title4", "contents5", true),
)

@Composable
fun DefaultCardView() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = purple,
        contentColor = MaterialTheme.colors.surface
    )


    Card(modifier = Modifier.fillMaxWidth()) {
        Box {
            Column {

                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "예약하기", style = typography.h3, modifier =
                        Modifier.padding(0.dp, 10.dp, 0.dp, 10.dp)
                    )

                    Button(
                        colors = mainButtonColor,
                        onClick = {},
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(10.dp)),
                    ) {
                        Text(text = "실시간 예약")
                    }
                }

                LazyColumn {
                    itemsIndexed(tmpData) { index, item ->
                        ContentText(
                            value = item.value, isBold = item.isBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContentText(value: String, isBold: Boolean) {
    Text(text = value, fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal)
}

@Preview
@Composable
private fun ShowView() {
    DefaultCardView()
}