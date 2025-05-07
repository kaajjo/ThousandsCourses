package kaajjo.thousandscourses.domain.model

import java.time.LocalDateTime

data class FavoriteCourse(
    val id: Int,
    val markedAt: LocalDateTime
)