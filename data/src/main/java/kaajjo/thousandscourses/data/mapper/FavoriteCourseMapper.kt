package kaajjo.thousandscourses.data.mapper

import kaajjo.thousandscourses.data.local.entity.FavoriteCourseEntity
import kaajjo.thousandscourses.domain.model.FavoriteCourse
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

fun FavoriteCourseEntity.toDomain(): FavoriteCourse {
    return FavoriteCourse(
        id = this.id,
        markedAt = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(this.markedDate),
            ZoneId.systemDefault()
        )
    )
}

fun FavoriteCourse.toEntity(): FavoriteCourseEntity {
    return FavoriteCourseEntity(
        id = this.id,
        markedDate = this.markedAt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()
    )
}