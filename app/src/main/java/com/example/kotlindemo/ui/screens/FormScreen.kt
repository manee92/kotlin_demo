package com.example.kotlindemo.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlindemo.R
import com.example.kotlindemo.ui.theme.LightGreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FormScreen(
) {
    Scaffold() {

        val name = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Name")
            TextField(
                value = name.value,
                onValueChange = { name.value = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Email")
            TextField(
                value = email.value,
                onValueChange = { email.value = it },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { submitForm(name.value, email.value) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Submit")
            }
        }
    }
}

fun submitForm(name: String, email: String) {
    // Implement form submission logic here
}

