package kaajjo.thousandscourses.onboarding.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import dev.chrisbanes.haze.rememberHazeState
import kaajjo.thousandscourses.onboarding.R
import kaajjo.thousandscourses.onboarding.components.CategoryRowWithTilt
import kaajjo.thousandscourses.onboarding.components.RegularCategoryRow
import kaajjo.thousandscourses.onboarding.components.SpecialCategoryRow
import kaajjo.thousandscourses.onboarding.logic.OnboardingViewModel
import kaajjo.thousandscourses.ui.button.AccentButton

interface OnboardingNavigator {
    fun navigateToLogin()
}

@Destination
@Composable
fun OnBoardingScreen(
    navigator: OnboardingNavigator,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
            ) {
                val categories = listOf(
                    listOf(
                        Pair("1С Админстрирование", false),
                        Pair("RabbitMQ", true),
                        Pair("Трафик", false),
                    ),
                    listOf(
                        Pair("Контент маркетинг", false),
                        Pair("B2B Маркетинг", false),
                        Pair("Google Аналитика", false),
                    ),
                    listOf(
                        Pair("UX исследователь", false),
                        Pair("Веб-аналитика", false),
                        Pair("Big Data", true),
                    ),
                    listOf(
                        Pair("Геймдизайн", false),
                        Pair("Веб-дизайн", false),
                        Pair("Cinema 4D", false),
                        Pair("Промпт инженеринг", false),
                    ),
                    listOf(
                        Pair("Webflow", false),
                        Pair("Three.js", true),
                        Pair("Парсинг", false),
                        Pair("Python-разработка", false),
                    )
                )

                val initialOffsets = listOf(120, 250, 160, 380, 270)

                val hazeState = rememberHazeState()
                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = "Тысячи курсов\nв одном месте",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(56.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CategoryRowWithTilt(
                        categories = categories[0],
                        hazeState = hazeState,
                        initialOffset = initialOffsets[0],
                        tiltAngle = -15f,
                        translationY = 10.dp,
                        zIndex = -1f
                    )

                    RegularCategoryRow(
                        categories = categories[1],
                        hazeState = hazeState,
                        initialOffset = initialOffsets[1]
                    )

                    CategoryRowWithTilt(
                        categories = categories[2],
                        hazeState = hazeState,
                        initialOffset = initialOffsets[2],
                        tiltAngle = 15f,
                        translationY = -10.dp,
                        invertZIndex = true,
                        zIndex = -1f
                    )

                    RegularCategoryRow(
                        categories = categories[3],
                        hazeState = hazeState,
                        initialOffset = initialOffsets[3]
                    )

                    SpecialCategoryRow(
                        categories = categories[4],
                        hazeState = hazeState,
                        initialOffset = initialOffsets[4]
                    )
                }
                Spacer(modifier = Modifier.height(96.dp))
            }
            AccentButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 32.dp),
                onClick = {
                    viewModel.completeFirstLaunch()
                    navigator.navigateToLogin()
                }
            ) {
                Text(stringResource(R.string.action_continue))
            }
        }
    }
}