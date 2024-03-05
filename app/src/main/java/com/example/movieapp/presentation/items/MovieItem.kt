package com.example.movieapp.presentation.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants


@Composable
fun MovieItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    movieId: Int,
    onNavigateToDetailsScreens: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .height(250.dp)
            .width(170.dp)
    ) {
        Column(
            modifier = Modifier.clickable {
                onNavigateToDetailsScreens.invoke(movieId)
            }
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(14.dp)),
                model = Constants.POSTER_PATH_URL + imageUrl,
                placeholder = painterResource(id = R.drawable.movie_no_internet_),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }
    }
}
