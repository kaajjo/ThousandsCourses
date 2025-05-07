package kaajjo.thousandscourses.data.network.api

import kaajjo.thousandscourses.data.network.dto.CourseDto
import retrofit2.Call
import retrofit2.http.GET

interface CoursesApiService {
    @GET("u/0/uc?id=15arTK7XT2b7Yv4BJsmDctA4Hg-BbS8-q&export=download")
    fun getCourses(): List<CourseDto>
}