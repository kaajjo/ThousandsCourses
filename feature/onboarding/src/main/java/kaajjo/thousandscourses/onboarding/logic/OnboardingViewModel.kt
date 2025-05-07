package kaajjo.thousandscourses.onboarding.logic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kaajjo.thousandscourses.domain.repository.SettingsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository
) : ViewModel() {
    fun completeFirstLaunch() {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.setFirstLaunch(false)
        }
    }
}