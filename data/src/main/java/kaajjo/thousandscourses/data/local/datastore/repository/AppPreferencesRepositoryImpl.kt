package kaajjo.thousandscourses.data.local.datastore.repository

import kaajjo.thousandscourses.data.local.datastore.AppPreferences
import kaajjo.thousandscourses.domain.repository.SettingsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val appPreferences: AppPreferences,
) : SettingsRepository {

    override suspend fun setFirstLaunch(value: Boolean) {
        appPreferences.setFirstLaunch(value)
    }

    override val firstLaunch: Flow<Boolean>
        get() = appPreferences.firstLaunch
}