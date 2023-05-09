package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ImageScreen(
) {
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.image001),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.image001),
                contentDescription = "Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.image001),
                contentDescription = "Image",
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 20.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.image001),
                contentDescription = "Image",
                colorFilter = ColorFilter.tint(Color.Green, blendMode = BlendMode.ColorBurn),
                modifier = Modifier
                    .clip(RoundedCornerShape(size = 20.dp))
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ani_8),
                contentDescription = "Image",
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
            )


        }

    }

}

