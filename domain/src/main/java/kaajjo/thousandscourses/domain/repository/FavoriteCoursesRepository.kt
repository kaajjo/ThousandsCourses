package kaajjo.thousandscourses.domain.repository

import kaajjo.thousandscourses.domain.model.FavoriteCourse
import kotlinx.coroutines.flow.Flow

interface FavoriteCoursesRepository {
    fun getAll(): Flow<List<FavoriteCourse>>
    suspend fun add(item: FavoriteCourse)
    suspend fun add(items: List<FavoriteCourse>)
    suspend fun delete(item: FavoriteCourse)
    suspend fun deleteById(id: Int)
}