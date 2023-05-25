package com.example.kotlindemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.kotlindemo.ui.screens.DemoApp
import com.example.kotlindemo.ui.theme.KotlinDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinDemoTheme (){
                DemoApp()
            }
        }
    }
}
