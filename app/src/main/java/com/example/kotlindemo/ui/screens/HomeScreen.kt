package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlindemo.R
import com.example.kotlindemo.ui.screens.charts.ChartScreenCanvas
import com.example.kotlindemo.ui.screens.charts.LineChartDemo
import com.example.kotlindemo.ui.theme.LightGreen

@Composable
fun DemoApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier.padding(all = 0.dp)

    ) {
        composable(route = "home") {
            HomeScreen(
                onLoginTap = { navController.navigate("login") },
                onImageTap = { navController.navigate("image") },
                onCardTap = { navController.navigate("card") },
                onFormTap = { navController.navigate("form") },
                onAppbarTap = { navController.navigate("appbar") },
                onBottomNavTap = { navController.navigate("bottom_nav") },
                onDrawerTap = { navController.navigate("drawer") },
                onTableTap = { navController.navigate("table") },
                onChartTap = { navController.navigate("chart") },
                onTapBarTap = { navController.navigate("tab_bar") },
                onListTap = { navController.navigate("list") },
                onGridTap = { navController.navigate("grid") },
                onStGridTap = { navController.navigate("st_grid") },
            )
        }
        composable(route = "login") {
            LoginScreen()
        }
        composable(route = "form") {
            FormScreen()
        }
        composable(route = "card") {
            CardScreen()
        }
        composable(route = "image") {
            ImageScreen()
        }
        composable(route = "appbar") {
            AppBarScreen()
        }
        composable(route = "bottom_nav") {
            BottomNavigationScreen()
        }
        composable(route = "drawer") {
            DrawerScreen()
        }
        composable(route = "table") {
            TableScreen()
        }
        composable(route = "chart") {
            LineChartDemo()
        }
        composable(route = "tab_bar") {
            TabBarScreen()
        }
        composable(route = "list") {
            ListScreen()
        }
        composable(route = "grid") {
            GridScreen()
        }
        composable(route = "st_grid") {
            StaggeredGridScreen()
        }
    }

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onLoginTap: () -> Unit,
    onImageTap: () -> Unit,
    onCardTap: () -> Unit,
    onFormTap: () -> Unit,
    onAppbarTap: () -> Unit,
    onBottomNavTap: () -> Unit,
    onDrawerTap: () -> Unit,
    onTableTap: () -> Unit,
    onChartTap: () -> Unit,
    onTapBarTap: () -> Unit,
    onListTap: () -> Unit,
    onGridTap: () -> Unit,
    onStGridTap: () -> Unit,
) {
    Scaffold() {

        Column(modifier = Modifier.padding(32.dp).verticalScroll(
            rememberScrollState()
        ),) {
            CustomButton(
                onTap = onLoginTap,
                text = stringResource(R.string.login)
            )
            CustomButton(
                onTap = onImageTap,
                text = stringResource(R.string.image)
            )
            CustomButton(
                onTap = onCardTap,
                text = stringResource(R.string.card_view)
            )
            CustomButton(
                onTap = onFormTap,
                text = stringResource(R.string.form)
            )
            CustomButton(
                onTap = onAppbarTap,
                text = stringResource(R.string.app_bar)
            )
            CustomButton(
                onTap = onBottomNavTap,
                text = stringResource(R.string.bottom_navigation)
            )
            CustomButton(
                onTap = onDrawerTap,
                text = stringResource(R.string.drawer)
            )
            CustomButton(
                onTap = onTableTap,
                text = stringResource(R.string.table)
            )
            CustomButton(
                onTap = onChartTap,
                text = stringResource(R.string.chart)
            )
            CustomButton(
                onTap = onTapBarTap,
                text = stringResource(R.string.tab_bar)
            )
            CustomButton(
                onTap = onListTap,
                text = stringResource(R.string.list)
            )
            CustomButton(
                onTap = onGridTap,
                text = stringResource(R.string.grid)
            )
            CustomButton(
                onTap = onStGridTap,
                text = stringResource(R.string.st_grid)
            )
        }
    }
}

@Composable
fun CustomButton(onTap: () -> Unit, text: String) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onTap,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = LightGreen,
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}

