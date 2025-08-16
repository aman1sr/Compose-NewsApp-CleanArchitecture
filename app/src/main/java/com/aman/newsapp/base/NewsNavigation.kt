package com.aman.newsapp.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aman.newsapp.screens.FilterScreen
import com.aman.newsapp.screens.NewsScreen
import com.aman.newsapp.screens.SavedScreen
import com.aman.newsapp.screens.SearchScreen

@Composable
fun NewsAppHostContainer() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentScreen =
        bottomBarScreen.find { it.route == currentDestination?.route } ?: Route.TopNews

    Scaffold(
        bottomBar = {
            NewsBottomNavigation(
                currentScreen = currentScreen
            ) {
                navigateSingleTopTo(it.route, navController)
            }
        }
    ) {
        NewsNavHost(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }

}

@Composable
fun NewsNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Route.TopNews.route,
        modifier = modifier
    ) {
        composable(route = Route.TopNews.route){
            NewsScreen(modifier.fillMaxWidth())
        }
         composable(route = Route.FilterNews.route){
            FilterScreen(modifier.fillMaxWidth())
        }
         composable(route = Route.SavedNews.route){
            SavedScreen(modifier.fillMaxWidth())
        }
         composable(route = Route.SearchNews.route){
            SearchScreen(modifier.fillMaxWidth())
        }

    }
}

@Composable
fun NewsBottomNavigation(
    currentScreen: Route,
    onIconSelected: (Route) -> Unit
) {
    NavigationBar {
        bottomBarScreen.forEach { screen ->
            NavigationBarItem(
                selected = screen == currentScreen,
                label = {
                    Text(text = stringResource(id = screen.resourceId))
                },
                icon = {
                    Icon(painter = painterResource(id = screen.icon), null)
                },
                onClick = {
                    onIconSelected.invoke(screen)
                }
            )
        }
    }
}


fun navigateSingleTopTo(
    route: String,
    navController: NavHostController
) {
    navController.navigate(route) {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
    }
}
