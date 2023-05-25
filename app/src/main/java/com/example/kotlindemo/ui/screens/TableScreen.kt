package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.Divider
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.kotlindemo.ui.theme.LightGreen

data class Invoice(val invoice: String, val date: String, val status: String, val amount: String)

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TableScreen(
) {
    val invoiceList = listOf(
        Invoice("51023", "15/04/2023", "Unpaid", amount = "$2,600"),
        Invoice("51024", "17/04/2023", "Pending", amount = "$900"),
        Invoice("51025", "20/04/2023", "Paid", amount = "$7,560"),
        Invoice("51026", "23/04/2023", "Pending", amount = "$300"),
        Invoice("51027", "30/04/2023", "Paid", amount = "$5,890"),
    )
    val column1Weight = .2f
    val column2Weight = .3f
    val column3Weight = .25f
    val column4Weight = .25f

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Data Table Demo")
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
        LazyColumn(
            Modifier.padding(8.dp)
        ) {
            item {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TableCell(
                        text = "Invoice",
                        weight = column1Weight,
                        alignment = TextAlign.Left,
                        title = true
                    )
                    TableCell(text = "Date", weight = column2Weight, title = true)
                    TableCell(text = "Status", weight = column3Weight, title = true)
                    TableCell(
                        text = "Amount",
                        weight = column4Weight,
                        alignment = TextAlign.Right,
                        title = true
                    )
                }
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }

            itemsIndexed(invoiceList) { _, invoice ->
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TableCell(
                        text = invoice.invoice,
                        weight = column1Weight,
                        alignment = TextAlign.Left
                    )
                    TableCell(text = invoice.date, weight = column2Weight)
                    StatusCell(text = invoice.status, weight = column3Weight)
                    TableCell(
                        text = invoice.amount,
                        weight = column4Weight,
                        alignment = TextAlign.Right
                    )
                }
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxHeight()
                        .fillMaxWidth()
                )
            }
        }
    }

}

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
    alignment: TextAlign = TextAlign.Center,
    title: Boolean = false
) {
    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(10.dp),
        fontWeight = if (title) FontWeight.Bold else FontWeight.Normal,
        textAlign = alignment,
    )
}

@Composable
fun RowScope.StatusCell(
    text: String,
    weight: Float,
    alignment: TextAlign = TextAlign.Center,
) {

    val color = when (text) {
        "Pending" -> Color(0xfff8deb5)
        "Paid" -> Color(0xffadf7a4)
        else -> Color(0xffffcccf)
    }
    val textColor = when (text) {
        "Pending" -> Color(0xffde7a1d)
        "Paid" -> Color(0xff00ad0e)
        else -> Color(0xffca1e17)
    }

    Text(
        text = text,
        Modifier
            .weight(weight)
            .padding(12.dp)
            .background(color, shape = RoundedCornerShape(50.dp)),
        textAlign = alignment,
        color = textColor
    )
}



