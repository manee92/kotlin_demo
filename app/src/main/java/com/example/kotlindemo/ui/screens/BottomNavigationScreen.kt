package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

sealed class BottomNav(val route: String, val label: String, val icon: ImageVector) {
    object Screen1 : BottomNav("screen1", "Screen 1", Icons.Filled.Home)
    object Screen2 : BottomNav("screen2", "Screen 2", Icons.Filled.List)
    object Screen3 : BottomNav("screen3", "Screen 3", Icons.Filled.Person)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationScreen(
) {
    val bottomNavItems = listOf(
        BottomNav.Screen1,
        BottomNav.Screen2,
        BottomNav.Screen3
    )
    val currentRoute = "screen1"
//    onNavItemSelected = { /* Handle navigation item selected */ }

    val selectedItem = bottomNavItems.find { it.route == currentRoute } ?: bottomNavItems.first()

    Scaffold(
        bottomBar = {
            BottomNavigation {
                bottomNavItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = selectedItem == screen,
                        onClick = {  },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) // content goes here
    }

}

