package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ImageScreen(
) {
    Scaffold() {
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

