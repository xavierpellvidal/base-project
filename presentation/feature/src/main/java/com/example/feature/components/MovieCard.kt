package com.example.feature.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.baseproject.feature.R
import com.example.feature.contract.state.MovieUiState

@Composable
internal fun MovieCard(
    modifier: Modifier = Modifier,
    movie: MovieUiState,
    onDeleteMovie: (Int) -> Unit,
) {
    Card(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
        ) {
            AsyncImage(
                model = movie.poster,
                contentDescription = movie.title,
                modifier =
                    Modifier
                        .width(100.dp)
                        .height(100.dp),
                placeholder = painterResource(R.drawable.movie_placeholder),
                contentScale = ContentScale.Crop,
            )

            Column(
                modifier =
                    Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = movie.year,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = movie.type,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            Box(
                modifier =
                    Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp),
            ) {
                when (movie.movieState) {
                    is MovieUiState.ContentState.Idle -> {
                        IconButton(onClick = { onDeleteMovie(movie.id) }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete movie",
                                tint = MaterialTheme.colorScheme.error,
                            )
                        }
                    }

                    is MovieUiState.ContentState.Deleting -> {
                        CircularProgressIndicator(
                            modifier = Modifier.size(24.dp),
                            strokeWidth = 2.dp,
                        )
                    }
                }
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun MovieCardPreview() {
    MaterialTheme {
        MovieCard(
            movie =
                MovieUiState(
                    id = 1,
                    title = "Inception",
                    year = "2010",
                    type = "Sci-Fi",
                    poster = "",
                ),
            onDeleteMovie = {},
        )
    }
}
