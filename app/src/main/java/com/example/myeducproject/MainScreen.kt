package com.example.myeducproject

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun MainScreen(
    vm:MainScreenViewModel ,
    text: String
) {
    val context = LocalContext.current
    Box{
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text)
            Row {
                IconButton(
                    onClick = {
                        Toast.makeText(context, "true", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(Icons.Default.Add,null)
                }
                IconButton(
                    onClick = {
                        Toast.makeText(context, "false", Toast.LENGTH_SHORT).show()
                    }
                ) {
                    Icon(Icons.Default.Clear,null)
                }
            }
        }
    }
}