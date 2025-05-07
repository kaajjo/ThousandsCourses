package kaajjo.thousandscourses.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    suspend fun setFirstLaunch(value: Boolean)
    val firstLaunch: Flow<Boolean>
}