package kaajjo.thousandscourses.main.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FilterAlt
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import kaajjo.thousandscourses.main.MainViewModel
import kaajjo.thousandscourses.main.R
import kaajjo.thousandscourses.ui.button.CircleButton
import kaajjo.thousandscourses.ui.card.CourseCard
import kaajjo.thousandscourses.ui.icon.ArrowDownUp
import kaajjo.thousandscourses.ui.textfield.RoundedTextField

interface MainNavigator {
    fun navigateToCourse(id: Int)
}

@Destination
@Composable
fun MainScreen(
    navigator: MainNavigator,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val courses by viewModel.courses.collectAsStateWithLifecycle()
    val favoriteCourses by viewModel.favoriteCourses.collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(innerPadding.calculateTopPadding()))
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                ) {
                    var searchQuery by rememberSaveable { mutableStateOf("") }
                    RoundedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(32.dp)
                                    .padding(start = 8.dp)
                            )
                        },
                        placeholder = { Text(stringResource(R.string.label_searching_courses)) },
                        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    CircleButton(
                        onClick = { },
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.FilterAlt,
                            contentDescription = null
                        )
                    }
                }
            }
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    TextButton(
                        onClick = { viewModel.sortByDesc() },
                        colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF12B956)),
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Text(
                            text = stringResource(R.string.sort_by_date),
                            style = MaterialTheme.typography.titleMedium
                        )
                        Icon(
                            imageVector = Icons.ArrowDownUp,
                            contentDescription = null
                        )
                    }
                }
            }
            items(courses, key = { it.id }) { course ->
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