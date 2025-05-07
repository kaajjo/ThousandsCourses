package ru.smarttech.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import kaajjo.thousandscourses.ui.card.CourseCard

interface FavoriteNavigator {
    fun navigateToCourse(id: Int)
}

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun FavoriteScreen(
    navigator: FavoriteNavigator,
    viewModel: FavoriteViewModel = hiltViewModel(),
) {
    val courses by viewModel.courses.collectAsStateWithLifecycle()
    val favoriteCourses by viewModel.favoriteCourses.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.Favorites)) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(12.dp),
        ) {
            items(
                items = courses.filter { course -> favoriteCourses.any { it.id == course.id } },
                key = { course -> course.id },
            ) { course ->
                CourseCard(
                    title = course.title,
                    description = course.text,
                    price = course.price,
                    rating = course.rate,
                    date = course.startDate,
                    marked = favoriteCourses.any { it.id == course.id },
                    onClick = { navigator.navigateToCourse(course.id) },
                    onBookmarkClick = {
                        if (favoriteCourses.any { it.id == course.id }) {
                            viewModel.removeFromFavorite(course)
                        } else {
                            viewModel.addToFavorite(course)
                        }
                    },
                    modifier = Modifier.animateItem()
                )
            }
        }
    }
}