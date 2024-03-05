package com.example.movieapp.presentation.bottom_bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieapp.R
import com.example.movieapp.presentation.theme.Background

sealed class BottomBarScreens(
    val title: String,
    val route: String,
    @DrawableRes val icons: Int,
) {
    object Home : BottomBarScreens(
        title = "Home", route = "home_route", icons = R.drawable.home_smile_svgrepo_com
    )

    object Search : BottomBarScreens(
        title = "Search", route = "search_route", icons = R.drawable.search_alt_2_svgrepo_com
    )

    object WatchList : BottomBarScreens(
        title = "Watch List",
        route = "watch_list_route",
        icons = R.drawable.favorite_heart_love_svgrepo_com
    )
}


@Composable
fun BottomNavigationScreen(
    navController: NavController, items: List<BottomBarScreens>
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation(
        modifier = Modifier, backgroundColor = if (isSystemInDarkTheme()) Background
        else Color.White
    ) {
        items.forEach { screens ->
            BottomNavigationItem(
                selected = currentDestination?.route == screens.route,
                onClick = {
                    navController.navigate(screens.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = screens.icons), contentDescription = null,
                        tint = androidx.compose.material3.MaterialTheme.colorScheme.onBackground
                    )
                },
                label = {
                    Text(
                        color = androidx.compose.material3.MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier,
                        text = screens.title
                    )
                },
                alwaysShowLabel = false,
                selectedContentColor = MaterialTheme.colors.onBackground,
            )
        }
    }
}