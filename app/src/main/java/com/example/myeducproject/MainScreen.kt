package com.example.myeducproject

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(
    vm:MainScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val fact by vm.currentFact
    Box{
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(fact.first, fontSize = 24.sp, modifier =  Modifier.padding(15.dp))
            Spacer(Modifier.height(24.dp))
            Row {
                IconButton(
                    onClick = {
                        if (vm.checkAnswer(true)){
                            Toast.makeText(context, "Правильно!", Toast.LENGTH_SHORT).show()
                            vm.nextFact()
                        }else{
                            Toast.makeText(context, "Неправильно(", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Modifier.clip(RoundedCornerShape(12.dp)).background(Color.Gray).size(48.dp)
                ) {
                    Icon(Icons.Default.Check,null, tint = Color.Green)
                }
                Spacer(Modifier.width(20.dp))
                IconButton(
                    onClick = {
                        if (vm.checkAnswer(false)){
                            Toast.makeText(context, "Правильно!", Toast.LENGTH_SHORT).show()
                            vm.nextFact()
                        }else{
                            Toast.makeText(context, "Неправильно(", Toast.LENGTH_SHORT).show()
                        }
                    },
                    Modifier.clip(RoundedCornerShape(12.dp)).background(Color.Gray).size(48.dp)
                ) {
                    Icon(Icons.Default.Clear,null, tint = Color.Red)
                }
            }
        }
    }
}