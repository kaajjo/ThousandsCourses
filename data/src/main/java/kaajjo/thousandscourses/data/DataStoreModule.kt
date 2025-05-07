package kaajjo.thousandscourses.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kaajjo.thousandscourses.data.local.datastore.AppPreferences
import kaajjo.thousandscourses.data.local.datastore.repository.SettingsRepositoryImpl
import kaajjo.thousandscourses.domain.repository.SettingsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile("app_preferences") }
        )
    }

    @Provides
    fun provideAppPreferences(dataStore: DataStore<Preferences>): AppPreferences {
        return AppPreferences(dataStore)
    }
    @Provides
    fun provideSettingsRepository(
        appPreferences: AppPreferences
    ): SettingsRepository {
        return SettingsRepositoryImpl(appPreferences)
    }
}