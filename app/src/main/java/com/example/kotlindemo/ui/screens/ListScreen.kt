package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.example.kotlindemo.R
import com.example.kotlindemo.ui.theme.*


val listItems = listOf(
    ListItem(1, "Jane doe", "Subtitle for item 1", R.drawable.avatar),
    ListItem(2, "Robert C. Williams", "Subtitle for item 2", R.drawable.avatar2),
    ListItem(3, "Kendrick M. Valdez", "Subtitle for item 3", R.drawable.avatar3)
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
                backgroundColor = LightGreen,
                contentColor = Color.White
            )
        }
    ) {

        MyList(listItems = listItems)
    }

}

@Composable
fun MyList(listItems: List<ListItem>) {
    LazyColumn {
        items(listItems) { item ->
            ListItem(item)
        }
    }
}

@Composable
fun ListItem(item: ListItem) {
    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = "Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .weight(1f)
            ) {
                Text(
                    text = item.title,
                    style = TextStyle(
                        color = Color(0xFF2b2b2b),
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(text = item.subtitle, style = MaterialTheme.typography.body2)
            }
            IconButton(
                onClick = {}
            ) {
                Icon(imageVector = Icons.Outlined.Phone, contentDescription = "")
            }
        }
    }
}


data class ListItem(
    val id: Int,
    val title: String,
    val subtitle: String,
    val image: Int
)
