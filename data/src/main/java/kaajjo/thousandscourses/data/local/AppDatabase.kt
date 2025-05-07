package kaajjo.thousandscourses.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kaajjo.thousandscourses.data.local.dao.FavoriteCoursesDao
import kaajjo.thousandscourses.data.local.entity.FavoriteCourseEntity

@Database(
    entities = [FavoriteCourseEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteCourseDao(): FavoriteCoursesDao
}