package com.example.movieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(
    navController: NavController,
    movieID: String?){
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieID
    }
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
                        verticalArrangement = Arrangement.Top) {
                        MovieRow(movie = newMovieList.first())
                        Spacer(modifier = Modifier.height(8.dp))
                        Divider()
                        Text("Movie Images")
                        HScrollableImageView(newMovieList)

            }
        }
    }
}

@Composable
private fun HScrollableImageView(newMovieList: List<Movie>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(200.dp),
                elevation = 5.dp
            ) {

                AsyncImage(
                    model = image,
                    contentDescription = "Movie Posters",
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }
}






