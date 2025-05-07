package kaajjo.thousandscourses.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kaajjo.thousandscourses.data.network.api.CoursesApiService
import kaajjo.thousandscourses.data.network.repository.CoursesRepositoryImpl
import kaajjo.thousandscourses.domain.repository.CoursesRepository

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun provideCoursesRepository(
        api: CoursesApiService,
    ): CoursesRepository {
        return CoursesRepositoryImpl(api)
    }
}