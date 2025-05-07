package kaajjo.thousandscourses.domain.repository

import kaajjo.thousandscourses.domain.model.Course
import kotlinx.coroutines.flow.Flow

interface CoursesRepository {
    suspend fun getCourses(): Flow<List<Course>>
}