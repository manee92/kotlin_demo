package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import com.example.kotlindemo.ui.theme.LightGreen


sealed class TabScreen(val title: String) {
    object Tab1 : TabScreen("Tab 1")
    object Tab2 : TabScreen("Tab 2")
    object Tab3 : TabScreen("Tab 3")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TabBarScreen(
) {
    val screens = listOf(TabScreen.Tab1, TabScreen.Tab2, TabScreen.Tab3)
    val currentScreen = TabScreen.Tab1
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My App")
                },
                navigationIcon = {
                    IconButton(onClick = { /* Handle navigation icon clicked */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Navigation menu")
                    }
                },
                backgroundColor = LightGreen,
                contentColor = Color.White
            )
        }
    ) {
        Column(Modifier.fillMaxSize()) {
            TabRow(
                selectedTabIndex = screens.indexOf(currentScreen),
                backgroundColor = MaterialTheme.colors.surface
            ) {
                screens.forEachIndexed { _, screen ->
                    Tab(
                        text = { Text(screen.title) },
                        selected = currentScreen == screen,
                        onClick = {  }
                    )
                }
            }
        }


    }

}


