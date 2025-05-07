package ru.smarttech.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kaajjo.thousandscourses.domain.model.Course
import kaajjo.thousandscourses.domain.model.FavoriteCourse
import kaajjo.thousandscourses.domain.repository.CoursesRepository
import kaajjo.thousandscourses.domain.repository.FavoriteCoursesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    val coursesRepository: CoursesRepository,
    val favoriteCoursesRepository: FavoriteCoursesRepository
) : ViewModel() {
    private var _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private var _courses = MutableStateFlow<List<Course>>(emptyList())
    val courses = _courses.asStateFlow()

    private var _favoriteCourses = MutableStateFlow<List<FavoriteCourse>>(emptyList())
    var favoriteCourses = _favoriteCourses.asStateFlow()

    private var loadingJob: Job? = null

    private var isSortingByDesc = false

    init {
        loadCourses()
        viewModelScope.launch(Dispatchers.IO) {
            favoriteCoursesRepository.getAll()
                .catch { Log.e("MainScreenViewModel", it.message.toString()) }
                .collect { _favoriteCourses.value = it }
        }
    }

    fun loadCourses() {
        loadingJob?.cancel()

        _isLoading.value = true

        loadingJob = viewModelScope.launch(Dispatchers.IO) {
            coursesRepository.getCourses()
                .catch { e ->
                    _isLoading.value = false
                    e.printStackTrace()
                }
                .collect { courses ->
                    _isLoading.value = false
                    _courses.value = courses

                    // sync with local data
                    favoriteCoursesRepository.add(
                        courses.filter { it.hasLike }.map { FavoriteCourse(it.id, java.time.LocalDateTime.now()) }
                    )
                }
        }
    }

    fun addToFavorite(course: Course) {
        val bookmarked = FavoriteCourse(
            id = course.id,
            markedAt = java.time.LocalDateTime.now()
        )
        viewModelScope.launch(Dispatchers.IO) {
            favoriteCoursesRepository.add(bookmarked)
        }
    }

    fun removeFromFavorite(course: Course) {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteCoursesRepository.deleteById(course.id)
        }
    }
}