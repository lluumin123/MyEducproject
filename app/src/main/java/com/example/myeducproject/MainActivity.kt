package com.example.myeducproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.d("TAG", "onCreate: Created")
        setContent {
            MainScreen()
        }
    }

    override fun onDestroy() {
        Log.d("TAG", "onDestroy: Destroyed")
        super.onDestroy()
    }
}
