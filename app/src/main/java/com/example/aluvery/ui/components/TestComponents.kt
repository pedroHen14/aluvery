package com.example.aluvery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R
import com.example.aluvery.ui.theme.Pink40
import com.example.aluvery.ui.theme.Purple80

@Preview
@Composable
fun ChallengePreview() {
    Row(modifier = Modifier
        .height(100.dp)
        .width(250.dp)) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(60.dp)
                .background(Color.Blue)
        )
        Column {
            Text(
                text = "Test 1",
                Modifier
                    .height(30.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(all = 8.dp),
                fontSize = 10.sp
            )
            Text(text = "Test 2",
                Modifier
                    .height(70.dp)
                    .padding(all = 8.dp), fontSize = 10.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengePreview2() {
    Surface(
        modifier = Modifier.padding(8.dp),
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Row(
            Modifier
                .height(150.dp)
                .widthIn(300.dp, 350.dp)
        ) {
            Box(
                Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Pink40,
                                Purple80
                            )
                        )
                    )
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .offset(x = (50).dp)
                        .size(100.dp)
                        .clip(shape = CircleShape)
                        .align(Alignment.Center)
                        .border(2.dp, Color.Blue, shape = CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = LoremIpsum(50).values.first(),
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsSectionChallengePreview() {
    Column {
        Text(
            text = "Promoções",
            modifier = Modifier.padding(
                start = 16.dp,
                top = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 16.dp,
                    bottom = 16.dp
                )
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProductItemChallengePreview(LoremIpsum(20).values.first())
            ProductItemChallengePreview()
            ProductItemChallengePreview(LoremIpsum(40).values.first())
        }
    }
}

@Composable
fun ProductItemChallengePreview(description: String = "") {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 260.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple80, Pink40
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(Alignment.BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
            if (description.isNotEmpty()) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(Purple80)
                        .heightIn(4.dp)
                        .padding(16.dp)
                ) {
                    Text(text = description)
                }
            }
        }
    }
}