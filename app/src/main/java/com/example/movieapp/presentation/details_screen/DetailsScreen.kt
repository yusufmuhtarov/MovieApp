package com.example.movieapp.presentation.details_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants

@Composable
fun DetailScreen(
    uiState: DetailScreenUiState.Success, modifier: Modifier = Modifier, goToMainScreen: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                goToMainScreen()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                )
            }
            Text(
                modifier = modifier.padding(top = 10.dp),
                text = stringResource(R.string.detail),
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                )
            }
        }
        Box(
            modifier = Modifier
        ) {
            Card {
                AsyncImage(
                    modifier = Modifier,
                    model = Constants.POSTER_PATH_URL + uiState.movieDetail.backdropPath,
                    placeholder = painterResource(id = R.drawable.movie_no_internet_),
                    contentDescription = null,
                )
            }
            Row(
                modifier = Modifier.padding(top = 170.dp, start = 30.dp),
            ) {
                Card(
                    modifier = Modifier
                        .height(130.dp)
                        .width(95.dp),
                ) {
                    AsyncImage(
                        model = Constants.POSTER_PATH_URL + uiState.movieDetail.posterPath,
                        placeholder = painterResource(id = R.drawable.movie_no_internet_),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 65.dp, start = 15.dp),
                    text = uiState.movieDetail.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
            }
        }
        Column(
            modifier = Modifier,
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    modifier = Modifier.padding(top = 3.dp),
                    painter = painterResource(id = R.drawable.calendarblank),
                    contentDescription = null
                )
                Text(
                    text = " ${uiState.movieDetail.releaseDate}  |  ",
                )
                Icon(
                    modifier = Modifier.padding(top = 3.dp),
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier,
                    text = "  ${uiState.movieDetail.runtime}Minutes  | ",
                )
                Icon(
                    modifier = Modifier.padding(top = 3.dp),
                    painter = painterResource(id = R.drawable.ticket),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(R.string.action),
                )
            }
        }
        Text(
            modifier = Modifier.padding(top = 30.dp, start = 30.dp),
            text = stringResource(R.string.about_movie),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
        Text(
            modifier = Modifier.padding(top = 15.dp, start = 25.dp, end = 30.dp),
            text = uiState.movieDetail.overview,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            textAlign = TextAlign.Center,
        )
    }
}