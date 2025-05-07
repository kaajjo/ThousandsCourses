package kaajjo.thousandscourses.data.network.mapper

import kaajjo.thousandscourses.data.network.dto.CourseDto
import kaajjo.thousandscourses.domain.model.Course
import java.time.LocalDate

fun CourseDto.toDomain(): Course {
    return Course(
        id = id,
        title = title,
        text = text,
        rate = rate.toFloatOrNull() ?: 0f,
        price = price.replace(" ", "").toIntOrNull() ?: 0,
        startDate = LocalDate.parse(startDate),
        hasLike = hasLike,
        publishDate = LocalDate.parse(this.publishDate)
    )
}