package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.unit.*
import com.example.kotlindemo.R


val listItems = listOf(
    ListItem(1, "Item 1", "Subtitle for item 1"),
    ListItem(2, "Item 2", "Subtitle for item 2"),
    ListItem(3, "Item 3", "Subtitle for item 3")
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "List Screen")
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

        MyList(listItems= listItems)
    }

}

@Composable
fun MyList(listItems: List<ListItem>) {
    LazyColumn {
        items(listItems) { item ->
            ListItem(item)
            Divider(color = Color.Gray)
        }
    }
}

@Composable
fun ListItem(item: ListItem) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = item.title, style = MaterialTheme.typography.h6)
            Text(text = item.subtitle, style = MaterialTheme.typography.body2)
        }
    }
}


data class ListItem(
    val id: Int,
    val title: String,
    val subtitle: String
)
