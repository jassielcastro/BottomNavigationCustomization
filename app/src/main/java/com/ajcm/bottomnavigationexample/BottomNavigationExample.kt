package com.ajcm.bottomnavigationexample

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ajcm.bottomnavigationexample.ui.theme.Blue

data class Item(
    val route: String,
    @DrawableRes val icon: Int
)

@Composable
fun BottomNavigationRoundRect(navController: NavController) {
    val itemList = listOf(
        Item(MAIN_SCREEN, R.drawable.ic_home),
        Item(FAVORITE_SCREEN, R.drawable.ic_star),
        Item(SEARCH_SCREEN, R.drawable.ic_search),
        Item(SETTINGS_SCREEN, R.drawable.ic_settings)
    )

    BottomNavigation(
        backgroundColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        itemList.forEach { item ->
            val isSelected = currentRoute == item.route
            val colorShape = if (isSelected) Blue else Color.Transparent

            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = "") },
                selectedContentColor = Blue,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false,
                selected = isSelected,
                modifier = Modifier
                    .drawCircleBehind(colorShape),
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
