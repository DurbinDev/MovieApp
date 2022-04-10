package com.example.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import java.util.*


@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}){

    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            //.height(130.dp)
            .clickable { onItemClick(movie.id) },
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
                
                Image(
                    painter = rememberAsyncImagePainter(model = movie.images[0]),
                    contentDescription = "Movie Poster",
                    contentScale = ContentScale.Crop,
                )
//                AsyncImage(
//                    model = (movie.images[0]),
//                    contentDescription = "Movie Poster",
//                    contentScale = ContentScale.Crop)
//                Icon(
//                    imageVector = Icons.Default.AccountBox,
//                    contentDescription = "Movie Image")
            }
            Column(modifier = Modifier.padding(4.dp)) {

                Text(movie.title,
                    style = MaterialTheme.typography.h6)

                Text( buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.White,
                        fontSize = 13.sp)){
                        append("Released: ")
                    }
                    withStyle(style = SpanStyle(
                        Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light
                    )){
                        append("${movie.year}")
                    }
                })

                Text( buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = Color.White,
                        fontSize = 13.sp)){
                        append("Genre: ")
                    }
                    withStyle(style = SpanStyle(
                        Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Light
                    )){
                        append("${movie.genre}")
                    }
                })

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.White,
                                fontSize = 13.sp)){
                                append("Plot: ")
                            }
                            withStyle(style = SpanStyle(
                                Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("${movie.plot}")
                            }
                        }, modifier = Modifier.padding(6.dp))

                        Divider(modifier = Modifier.padding(bottom = 3.dp))

                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.White,
                                fontSize = 13.sp)){
                                append("Director: ")
                            }
                            withStyle(style = SpanStyle(
                                Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("${movie.director}")
                            }
                        })

                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.White,
                                fontSize = 13.sp)){
                                append("Actors: ")
                            }
                            withStyle(style = SpanStyle(
                                Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("${movie.actors}")
                            }
                        })

                        Text( buildAnnotatedString {
                            withStyle(style = SpanStyle(
                                color = Color.White,
                                fontSize = 13.sp)){
                                append("Rating: ")
                            }
                            withStyle(style = SpanStyle(
                                Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Light
                            )){
                                append("${movie.rating}")
                            }
                        })
                    }
                }


                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Arrow down",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        },
                    tint = Color.Black
                )
            }
        }
    }
}