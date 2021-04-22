package com.odin.composesample.reservation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.odin.composesample.R
import com.odin.composesample.reservation.data.ReservationData
import com.odin.composesample.theme.green200

private val tmpData = arrayListOf(
    ReservationData(0, "상품/시간", "contents1", false),
    ReservationData(1, "매장정보", "contents2", false),
    ReservationData(2, "상품가격", "contents3", true)
)

@Composable
fun TopLayout() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = green200,
        contentColor = MaterialTheme.colors.surface
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = "예약하기",
                fontSize = 20f.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 30.dp)
            )

            LazyColumn {
                items(tmpData) { item ->
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { }
                            .padding(0.dp, 4.dp, 0.dp, 4.dp)
                    ) {

                        val (title, value) = createRefs()
                        createHorizontalChain(
                            title,
                            value,
                            chainStyle = ChainStyle.Packed
                        )

                        Text(
                            text = item.title,
                            color = colorResource(R.color.gray010),
                            modifier = Modifier
                                .constrainAs(title) {
                                    linkTo(
                                        start = parent.start,
                                        startMargin = 0.dp,
                                        end = value.start,
                                        endMargin = 0.dp
                                    )
                                }
                                .width(80.dp)
                        )
                        Text(
                            text = item.value,
                            color = colorResource(R.color.black_1),
                            modifier = Modifier.constrainAs(value) {
                                linkTo(
                                    start = title.end,
                                    startMargin = 16.dp,
                                    end = parent.end,
                                    endMargin = 16.dp
                                )
                                width = Dimension.fillToConstraints
                            },
                            fontWeight = if (item.isBold) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview
@Composable
private fun ShowTopView() {
    TopLayout()
}