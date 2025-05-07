package kaajjo.thousandscourses.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kaajjo.thousandscourses.data.local.AppDatabase
import kaajjo.thousandscourses.data.local.dao.FavoriteCoursesDao
import kaajjo.thousandscourses.data.local.repository.FavoriteCourseRepositoryImpl
import kaajjo.thousandscourses.domain.repository.FavoriteCoursesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "main_db"
        ).build()
    }

    @Provides
    fun provideFavoriteCoursesDao(database: AppDatabase): FavoriteCoursesDao {
        return database.favoriteCourseDao()
    }

    @Provides
    fun provideFavoriteRepository(
        dao: FavoriteCoursesDao
    ): FavoriteCoursesRepository {
        return FavoriteCourseRepositoryImpl(dao)
    }
}