package kaajjo.thousandscourses.data.network.dto

data class CoursesResponse(
    val courses: List<CourseDto>
)

data class CourseDto(
    val id: Int,
    val title: String,
    val text: String,
    val rate: String,
    val price: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String,
)