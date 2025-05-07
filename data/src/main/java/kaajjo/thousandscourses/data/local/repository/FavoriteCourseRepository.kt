package kaajjo.thousandscourses.data.local.repository

import kaajjo.thousandscourses.data.local.dao.FavoriteCoursesDao
import kaajjo.thousandscourses.data.mapper.toDomain
import kaajjo.thousandscourses.data.mapper.toEntity
import kaajjo.thousandscourses.domain.model.FavoriteCourse
import kaajjo.thousandscourses.domain.repository.FavoriteCoursesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavoriteCourseRepositoryImpl @Inject constructor(
    private val favoriteCourseDao: FavoriteCoursesDao
): FavoriteCoursesRepository {
    override fun getAll(): Flow<List<FavoriteCourse>> =
        favoriteCourseDao.getAll().map { items -> items.map { it.toDomain() } }

    override suspend fun add(item: FavoriteCourse) {
        favoriteCourseDao.insert(item.toEntity())
    }

    override suspend fun add(items: List<FavoriteCourse>) {
        favoriteCourseDao.insertAll(items.map { it.toEntity() })
    }

    override suspend fun delete(item: FavoriteCourse) {
        favoriteCourseDao.delete(item.toEntity())
    }

    override suspend fun deleteById(id: Int) {
        favoriteCourseDao.deleteById(id)
    }
}