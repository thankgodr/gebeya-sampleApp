package com.richard.carsapp.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.richard.carsapp.domain.model.CarMake
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SingleCarMakeView(carMake: CarMake, modifier: Modifier = Modifier) {
    Card(
        elevation = 5.dp,
        shape = CircleShape,
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage( // CoilImage, FrescoImage
                imageModel = carMake.imageUrl,
                modifier = modifier
                    .width(50.dp)
                    .height(50.dp),
                // shows a shimmering effect when loading an image.
                shimmerParams = ShimmerParams(
                    baseColor = Color.Gray,
                    highlightColor = Color.White,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
                // shows an error text message when request failed.
                failure = {
                    Text(text = "failed.")
                }
            )

        }
    }
}