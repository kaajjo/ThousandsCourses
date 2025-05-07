package kaajjo.thousandscourses.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "favorite_courses"
)
data class FavoriteCourseEntity(
    @PrimaryKey
    val id: Int,
    val markedDate: Long
)