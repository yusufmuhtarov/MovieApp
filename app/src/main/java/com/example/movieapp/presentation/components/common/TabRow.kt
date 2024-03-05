package com.example.movieapp.presentation.components.common

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieapp.presentation.items.TabRowItem
import com.example.movieapp.presentation.screen.HomeScreenUiState
import kotlinx.coroutines.launch

@SuppressLint("RememberReturnType")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    uiState: HomeScreenUiState.Success,
    onNavigateToDetailsScreens: (Int) -> Unit,
) {
    val listOf = listOf(
        uiState.topRatedMovies,
        uiState.nowPlayingMovies,
        uiState.upcomingMovies,
        uiState.popularMovies,
    )

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { listOf.size }

    val defaultIndicator = @Composable { tagPosition: List<TabPosition> ->
        val indicatorWidth = 4.dp
        val currentTabPosition = tagPosition[pagerState.currentPage]

        Box(
            modifier = modifier
                .fillMaxHeight()
                .width(indicatorWidth)
                .offset(x = currentTabPosition.left)
        )
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        ScrollableTabRow(
            modifier = Modifier,
            selectedTabIndex = pagerState.currentPage,
            indicator = defaultIndicator,
            containerColor = Color.Transparent
        ) {
            listOf.forEachIndexed { index, _ ->
                val header = getListOfPageByPosition(position = index)
                Tab(
                    text = {
                        Text(
                            color = MaterialTheme.colorScheme.onBackground,
                            text = header,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,

                            )
                    },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                )
            }
        }
        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) { movie ->
            val scope = listOf[movie]
            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(items = scope, key = { it.movieId }) {
                    TabRowItem(
                        imageUrl = it.moviePosterImage,
                        movieId = it.movieId,
                        onNavigateToDetailsScreen = onNavigateToDetailsScreens
                    )
                }
            }
        }
    }
}

@Composable
fun getListOfPageByPosition(position: Int): String = when (position) {
    0 -> "Top Rated"
    1 -> "Now Playing"
    2 -> "Upcoming"
    else -> "Popular"
}


