package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.*
import coil.compose.rememberAsyncImagePainter
import com.example.kotlindemo.ui.theme.LightGreen

val gridItemsList = listOf(
    GridItem(
        1,
        "Item 1",
        "Subtitle for item 1",
        "http://eyesofwild.com/wp-content/uploads/photo-gallery/imported_from_media_libray/yau16-23.jpg"
    ),
    GridItem(
        2,
        "Item 2",
        "Subtitle for item 2",
        "http://eyesofwild.com/wp-content/uploads/photo-gallery/imported_from_media_libray/yfb17-4.jpg"
    ),
    GridItem(
        3,
        "Item 3",
        "Subtitle for item 3",
        "http://eyesofwild.com/wp-content/uploads/photo-gallery/imported_from_media_libray/ya16-27.jpg"
    ),
    GridItem(
        4,
        "Item 4",
        "Subtitle for item 4",
        "http://eyesofwild.com/wp-content/uploads/photo-gallery/imported_from_media_libray/yfb17-36.jpg"
    )
)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GridScreen(

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
                backgroundColor = LightGreen,
                contentColor = Color.White
            )
        }
    ) {

        MyGrid(gridItemsList = gridItemsList)
    }

}

@Composable
fun MyGrid(gridItemsList: List<GridItem>, columns: Int = 2) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(gridItemsList) { item ->
            GridItemView(item)
        }
    }
}

@Composable
fun GridItemView(item: GridItem) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.imageUrl),
            contentDescription = item.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Crop
        )
        Text(text = item.title, style = MaterialTheme.typography.h6)
        Text(text = item.subtitle, style = MaterialTheme.typography.body2)
    }
}


data class GridItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val imageUrl: String
)