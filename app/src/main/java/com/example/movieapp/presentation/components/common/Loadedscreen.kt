package com.example.movieapp.presentation.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.R
import com.example.movieapp.presentation.items.MovieItem
import com.example.movieapp.presentation.models.main_screen_models.MovieUiModel
import com.example.movieapp.presentation.screen.HomeScreenUiState
import com.example.movieapp.presentation.theme.mainBackground
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.collections.immutable.ImmutableList

@Composable
fun LoadedMainScreen(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState.Success,
    onNavigateToSearchScreen: () -> Unit,
    onNavigateToDetailsScreens: (Int) -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }
    val systemUiController = rememberSystemUiController()
    val colorBackground = MaterialTheme.colorScheme.background
    Scaffold { innerPadding ->
        BoxWithConstraints {
            val scroll = rememberScrollState()
            val screen = maxHeight
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scroll)
            ) {
                Box(
                    modifier = modifier
                        .padding(innerPadding)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(top = 12.dp)
                    ) {
                        Text(
                            modifier = Modifier,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground,
                            text = stringResource(R.string.what_do_you_want_to_watch)
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .padding(12.dp)
                                .padding(horizontal = 4.dp)
                                .clickable {
                                    onNavigateToSearchScreen()
                                }
                                .fillMaxWidth(),
                            value = searchText,
                            onValueChange = {
                                searchText = it
                            },
                            shape = RoundedCornerShape(25.dp),
                            placeholder = {
                                Text(text = stringResource(R.string.search))
                            },
                            enabled = false
                        )
                        MoviesBlock(
                            movieList = uiState.popularMovies,
                            onNavigateToDetailsScreens = onNavigateToDetailsScreens
                        )
                        Column(
                            modifier = modifier.height(screen)

                        ) {
                            TabRow(
                                uiState = uiState,
                                onNavigateToDetailsScreens = onNavigateToDetailsScreens,
                            )
                        }
                    }
                }
            }
        }
        SideEffect {
            systemUiController.setStatusBarColor(colorBackground)
            systemUiController.setNavigationBarColor(colorBackground)
        }
    }
}

@Composable
fun MoviesBlock(
    movieList: ImmutableList<MovieUiModel>,
    onNavigateToDetailsScreens: (Int) -> Unit,
) {
    LazyRow {
        items(
            items = movieList,
            key = { it.movieId },
        ) {
            MovieItem(
                imageUrl = it.moviePosterImage,
                movieId = it.movieId,
                onNavigateToDetailsScreens = onNavigateToDetailsScreens
            )
        }
    }
}

