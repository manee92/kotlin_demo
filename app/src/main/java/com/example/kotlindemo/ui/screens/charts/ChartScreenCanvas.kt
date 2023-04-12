package com.example.kotlindemo.ui.screens.charts
import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ChartScreenCanvas() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Chart Demo") }) }
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val data = remember { listOf(30f, 50f, 70f, 90f, 110f) }
            Chart(data)
        }
    }
}

@Composable
fun Chart(data: List<Float>) {
    Canvas(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val max = data.maxOrNull() ?: 0f
        val stepSize = size.width / (data.size - 1)

        drawLine(
            start = Offset(0f, size.height),
            end = Offset(size.width, size.height),
            color = Color.Gray,
            strokeWidth = 2f
        )

        data.forEachIndexed { index, value ->
            val x = index * stepSize
            val y = size.height - (value / max) * size.height

            drawCircle(
                color = Color.Blue,
                radius = 6f,
                center = Offset(x, y),
                style = Stroke(width = 2f)
            )

            if (index < data.size - 1) {
                val nextX = (index + 1) * stepSize
                val nextY = size.height - (data[index + 1] / max) * size.height

                drawLine(
                    start = Offset(x, y),
                    end = Offset(nextX, nextY),
                    color = Color.Blue,
                    strokeWidth = 2f
                )
            }
        }
    }
}
