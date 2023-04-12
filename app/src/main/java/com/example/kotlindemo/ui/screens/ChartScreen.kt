package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChartScreen(
) {
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
        Column(
            modifier = Modifier.fillMaxSize().padding(all = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.image001),
                contentDescription = "Image",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "This is some text",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(top = 16.dp)
            )

        }

    }

}

