package com.example.movieapp

import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent()
            }
        }
    }
}
@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = Color(0xFF223538),
                    elevation = 5.dp,
                ) {
                    Text(text = "Movies", textAlign = TextAlign.Center)
                }
            }) {
                content()
        }
    }
}
@Composable
fun MainContent(movieList: List<String> = listOf(
        "Avatar",
        "Blade",
        "Harry Potter",
        "Avengers",
        "SpiderMan",
        "Iron-Man"
)){
    Column(
        modifier = Modifier
            .padding(12.dp)) {
        LazyColumn {
            items(movieList){
                MovieRow(movie = it){ movie ->
                    Log.d("tag", "tag $movie")
                }
            }
        }
    }
}


@Composable
fun MovieRow(movie: String, onItemClick: (String) -> Unit = {}){
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable { onItemClick(movie) },
            shape = RoundedCornerShape(CornerSize(16.dp)),
            backgroundColor = Color(0xFF005261),
            elevation = 6.dp){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .size(100.dp),
                    shape = CircleShape,
                    elevation = 5.dp){
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Movie Image")
            }
            Text(movie)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MyApp {
       MainContent()
   }
}