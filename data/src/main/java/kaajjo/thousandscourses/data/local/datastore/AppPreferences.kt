package kaajjo.thousandscourses.data.local.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppPreferences @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {
    private val firstLaunchKey = booleanPreferencesKey("first_launch")

    suspend fun setFirstLaunch(value: Boolean) {
        dataStore.edit { settings ->
            settings[firstLaunchKey] = value
        }
    }

    val firstLaunch = dataStore.data.map { preferences ->
        preferences[firstLaunchKey] != false
    }
}