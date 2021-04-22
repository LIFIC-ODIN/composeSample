package com.odin.composesample.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.odin.composesample.R
import com.odin.composesample.reservation.data.DesignerData


private val tmpDesignerData = arrayListOf(
    DesignerData(1, "A", "김길동", R.drawable.ic_launcher_background, arrayListOf("1", "2", "3")),
    DesignerData(2, "S", "홍길동", R.drawable.ic_launcher_background, arrayListOf("1", "12", "31")),
    DesignerData(3, "A", "일이삼", R.drawable.ic_launcher_background, arrayListOf("1", "5", "15")),
    DesignerData(4, "A", "라이픽", R.drawable.ic_launcher_background, arrayListOf("1", "12", "13")),
    DesignerData(5, "B", "김명성", R.drawable.ic_launcher_background, arrayListOf("4", "5", "23")),
    DesignerData(6, "C", "인포", R.drawable.ic_launcher_background, arrayListOf("1", "8", "27")),
    DesignerData(7, "B", "이름이요", R.drawable.ic_launcher_background, arrayListOf("5", "10", "21"))
)

@Composable
fun DesignerLayout() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn {
            items(tmpDesignerData) { item->
                ConstraintLayout(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { }
                ) {

                    val (image, title, subtitle, space, source, button) = createRefs()
                    createVerticalChain(title, subtitle, space, source, chainStyle = ChainStyle.Packed)

                    Image(
                        painter = painterResource(id = item.photoUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .constrainAs(image) {
                                linkTo(
                                    top = parent.top,
                                    topMargin = 16.dp,
                                    bottom = parent.bottom,
                                    bottomMargin = 16.dp
                                )
                                linkTo(start = parent.start, end = title.start)
                            }
                    )
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.constrainAs(title) {
                            linkTo(
                                start = image.end,
                                startMargin = 16.dp,
                                end = button.start,
                                endMargin = 16.dp
                            )
                            width = Dimension.fillToConstraints
                        }
                    )
                    Spacer(
                        Modifier
                            .height(8.dp)
                            .constrainAs(space) {
                                linkTo(top = subtitle.bottom, bottom = source.top)
                            }
                    )
                    Text(
                        text = item.grade,
                        style = MaterialTheme.typography.caption,
                        modifier = Modifier.constrainAs(source) {
                            start.linkTo(title.start)
                            width = Dimension.fillToConstraints
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowDesignView() {
    DesignerLayout()
}