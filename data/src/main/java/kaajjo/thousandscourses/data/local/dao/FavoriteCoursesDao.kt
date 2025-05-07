package kaajjo.thousandscourses.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kaajjo.thousandscourses.data.local.entity.FavoriteCourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCoursesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: FavoriteCourseEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(items: List<FavoriteCourseEntity>)

    @Query("SELECT * FROM favorite_courses ORDER BY markedDate DESC")
    fun getAll(): Flow<List<FavoriteCourseEntity>>

    @Delete
    suspend fun delete(item: FavoriteCourseEntity)

    @Query("DELETE FROM favorite_courses WHERE id = :id")
    suspend fun deleteById(id: Int)
}