package com.odin.composesample.reservation.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.odin.composesample.R

@Composable
fun BottomLayout() {

    val mainButtonColor = ButtonDefaults.buttonColors(
        backgroundColor = colorResource(id = R.color.purple_1),
        contentColor = MaterialTheme.colors.surface
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
        ) {

            val (title, subtitle, button) = createRefs()
            createVerticalChain(title, subtitle, button, chainStyle = ChainStyle.Packed)

            Text(
                text = "총 결제금액",
                fontSize = 12.sp,
                color = androidx.compose.ui.graphics.Color.LightGray,
                modifier = Modifier.constrainAs(title) {
                    linkTo(
                        start = parent.start,
                        startMargin = 16.dp,
                        end = button.start,
                        endMargin = 16.dp
                    )
                    linkTo(
                        top = parent.top,
                        topMargin = 5.dp,
                        bottom = subtitle.top,
                        bottomMargin = 5.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )
            Text(
                text = "4,233,520",
                fontSize = 16.sp,
                color = androidx.compose.ui.graphics.Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.constrainAs(subtitle) {
                    linkTo(
                        start = parent.start,
                        startMargin = 16.dp,
                        end = button.start,
                        endMargin = 16.dp
                    )
                    linkTo(
                        top = title.bottom,
                        topMargin = 5.dp,
                        bottom = parent.bottom,
                        bottomMargin = 5.dp
                    )
                    width = Dimension.fillToConstraints
                }
            )

            Button(
                colors = mainButtonColor,
                onClick = {},
                modifier = Modifier
                    .clip(RoundedCornerShape(28.dp))
                    .width(200.dp)
                    .height(56.dp)
                    .constrainAs(button) {
                        linkTo(
                            start = title.end,
                            startMargin = 16.dp,
                            end = parent.end,
                            endMargin = 16.dp
                        )
                        linkTo(
                            top = parent.top,
                            topMargin = 5.dp,
                            bottom = parent.bottom,
                            bottomMargin = 5.dp
                        )
                        width = Dimension.fillToConstraints
                    }
            ) {
                Text(text = "예약하기", color = colorResource(id = R.color.gray090))
            }
        }
    }
}

@Preview
@Composable
private fun ShowTopView() {
    BottomLayout()
}