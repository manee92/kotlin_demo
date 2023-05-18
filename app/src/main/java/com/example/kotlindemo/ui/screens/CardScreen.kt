package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CardScreen(
) {
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 20.dp)
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = 4.dp,
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Card Title",
                        style = MaterialTheme.typography.h6,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "This is some sample text for the card.",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            Card(
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.medium,
                elevation = 8.dp,
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.image001),
                        contentDescription = "Image",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "This is some sample text for the card.",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            Card(
                modifier = Modifier.padding(16.dp),
                shape = MaterialTheme.shapes.large,
                elevation = 4.dp,
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "This is a simple card with a shadow",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "This is some sample text for the card.",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            Card(
                shape = RoundedCornerShape(30.dp),
                elevation = 10.dp,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Round corner shape", modifier = Modifier.padding(16.dp))
            }
            Card(
                elevation = 10.dp,
                contentColor = Color.Blue,
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Text with card content color (Blue)",
                    modifier = Modifier.padding(16.dp)
                )
            }


        }

    }

}

