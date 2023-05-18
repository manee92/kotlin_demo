package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.R
import com.example.kotlindemo.ui.theme.LightGreen

sealed class BottomNav(val route: String, val label: String, val icon: ImageVector) {
    object Screen1 : BottomNav("screen1", "Dashboard", Icons.Filled.Home)
    object Screen2 : BottomNav("screen2", "Contacts", Icons.Filled.List)
    object Screen3 : BottomNav("screen3", "Profile", Icons.Filled.Person)
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomNavigationScreen(
) {
    val navController = rememberNavController()

    val bottomNavItems = listOf(
        BottomNav.Screen1,
        BottomNav.Screen2,
        BottomNav.Screen3
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My App")
                },
                backgroundColor = LightGreen,
                contentColor = Color.White
            )
        },
        bottomBar = {
            BottomNavigation (){
                val routeBack by navController.currentBackStackEntryAsState()
                val currentRoute = routeBack?.destination?.route
                bottomNavItems.forEach { screen ->
                    BottomNavigationItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) }
                    )
                }
            }
        }
    ) {
        BottomNavScreens(navController = navController)
    }// content goes here

}

@Composable
fun BottomNavScreens(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNav.Screen1.route) {
        composable(BottomNav.Screen1.route) {
            Dashboard()
        }
        composable(BottomNav.Screen2.route) {
            ContactScreen()
        }
        composable(BottomNav.Screen3.route) {
            ProfileScreen()
        }
    }
}



@Composable
fun Dashboard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = 8.dp,
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Card Title",
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.image001),
                    contentDescription = "Image",
                    modifier = Modifier.fillMaxWidth().height(200.dp)
                )
            }
        }
    }
}

@Composable
fun ContactScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Contact Screen",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Profile Screen",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}