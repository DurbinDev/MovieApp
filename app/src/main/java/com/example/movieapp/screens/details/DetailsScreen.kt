package com.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.screens.home.MainContent

@Composable
fun DetailsScreen(
        navController: NavController,
        movieData: String?){
            Scaffold(
    topBar = {
        TopAppBar(
            backgroundColor = Color(0xFF223538),
            elevation = 5.dp,
        ) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back arrow",

                    Modifier.clickable {
                        navController.popBackStack()
                    })
                Row (
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){

                    Text(text = "Movies", textAlign = TextAlign.Center)
                }

        }
    }) {
                Surface(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {

                        Text(movieData.toString(), style = MaterialTheme.typography.h4)

            }
        }
    }
}






