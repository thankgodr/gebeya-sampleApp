package com.richard.carsapp.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.richard.carsapp.R
import com.richard.carsapp.domain.model.Car
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SingleCarView(car: Car, modifier: Modifier = Modifier) {
    Card(
        elevation = 5.dp,
        modifier = Modifier.padding(16.dp),
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Box() {

                GlideImage(
                    // CoilImage, FrescoImage
                    imageModel = car.imageUrl,
                    modifier = modifier
                        .height(400.dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(5.dp)),
                    // shows a shimmering effect when loading an image.
                    shimmerParams = ShimmerParams(
                        baseColor = MaterialTheme.colors.background,
                        highlightColor = Color.White,
                        durationMillis = 350,
                        dropOff = 0.65f,
                        tilt = 20f
                    ),
                    // shows an error text message when request failed.
                    failure = {
                        Text(text = "image request failed.")
                    },
                )

                Icon(
                    painter = painterResource(id = R.mipmap.ic_heart),
                    contentDescription = stringResource(id = R.string.loveIcon),
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                        .align(Alignment.TopEnd),
                    tint = Color.White
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = car.title,
                    fontWeight = FontWeight.Bold
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Filled.Star,
                        contentDescription = stringResource(id = R.string.rate),
                        tint = colorResource(id = R.color.themeYellow)
                    )
                    Text(
                        text = ((Math.round(car.gradeScore * 10.0)) / 10.0).toString()
                    )
                }
            }

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Car Make"
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = car.marketplacePrice.toString()
                )

                Icon(
                    Icons.Rounded.Add,
                    contentDescription = stringResource(id = R.string.rate)
                )
            }

        }
    }
}