package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

data class User(val name: String, val age: Int, val occupation: String)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TableScreen(
) {
    val users = listOf(
        User("Alice", 25, "Engineer"),
        User("Bob", 30, "Designer"),
        User("Charlie", 40, "Manager")
    )
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
                backgroundColor = Color.Blue,
                contentColor = Color.White
            )
        }
    ) {
        LazyColumn(
            Modifier.padding(16.dp)
        ) {
            item {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Name")
                    Text(text = "Age")
                    Text(text = "Occupation")
                }
            }

            itemsIndexed(users) { index, user ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = user.name)
                    Text(text = user.age.toString())
                    Text(text = user.occupation)
                }

                if (index < users.size - 1) {
                    Divider()
                }
            }
        }
    }

}

