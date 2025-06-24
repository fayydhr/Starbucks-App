package com.example.stk.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class StkBottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

object StkNavbarRepository{
    val items = listOf(
        StkBottomNavigationItem(
            title = "Menu",
            route = "Menu",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Default.Home
        ),
        StkBottomNavigationItem(
            title = "Reward",
            route = "Reward",
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Default.ShoppingCart
        ),
        StkBottomNavigationItem(
            title = "Profile",
            route = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Default.Person
        ),
    )
}