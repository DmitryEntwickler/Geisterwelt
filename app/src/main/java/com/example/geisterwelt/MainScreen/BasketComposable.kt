package com.example.geisterwelt.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.geisterwelt.R

@Composable
fun BasketComposable() {

    Column(modifier = Modifier.background(Color.Black).fillMaxSize()){

        Text(text = "Korb", color = Color.White)


    }

}