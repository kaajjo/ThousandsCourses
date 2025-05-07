package kaajjo.thousandscourses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigateTo
import com.ramcosta.composedestinations.rememberNavHostEngine
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.spec.NavGraphSpec
import dagger.hilt.android.AndroidEntryPoint
import kaajjo.thousandscourses.account.destinations.AccountScreenDestination
import kaajjo.thousandscourses.domain.repository.SettingsRepository
import kaajjo.thousandscourses.login.screen.LoginNavigator
import kaajjo.thousandscourses.login.screen.destinations.LoginScreenDestination
import kaajjo.thousandscourses.main.MainViewModel
import kaajjo.thousandscourses.main.screen.MainNavigator
import kaajjo.thousandscourses.main.screen.destinations.MainScreenDestination
import kaajjo.thousandscourses.onboarding.screen.OnboardingNavigator
import kaajjo.thousandscourses.onboarding.screen.destinations.OnBoardingScreenDestination
import kaajjo.thousandscourses.ui.ThousandsCoursesTheme
import kaajjo.thousandscourses.ui.bottombar.ThemedNavigationBarItem
import kaajjo.thousandscourses.ui.icon.Account
import kaajjo.thousandscourses.ui.icon.BookmarkBar
import kaajjo.thousandscourses.ui.icon.Home
import ru.smarttech.favorite.FavoriteNavigator
import ru.smarttech.favorite.destinations.FavoriteScreenDestination
import java.util.prefs.Preferences
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject lateinit var settingsRepository: SettingsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThousandsCoursesTheme {
                Surface {
                    val firstLaunch = settingsRepository.firstLaunch.collectAsState(initial = false)
                    val engine = rememberNavHostEngine()
                    val navController = engine.rememberNavController()
                    val currentRoute =
                        navController.currentBackStackEntryAsState().value?.destination?.route

                    LaunchedEffect(firstLaunch.value) {
                        if (firstLaunch.value) {
                            navController.navigateTo(OnBoardingScreenDestination)
                        }
                    }

                    Scaffold(
                        bottomBar = {
                            if (currentRoute !in setOf(
                                    OnBoardingScreenDestination.route,
                                    LoginScreenDestination.route
                                ) && currentRoute != null
                            ) {
                                BottomAppBar {
                                    ThemedNavigationBarItem(
                                        selected = currentRoute == MainScreenDestination.route,
                                        onClick = {
                                            navController.navigateTo(MainScreenDestination)
                                        },
                                        icon = { Icon(Icons.Home, contentDescription = null) },
                                        label = { Text("Главная") }
                                    )
                                    ThemedNavigationBarItem(
                                        selected = currentRoute == FavoriteScreenDestination.route,
                                        onClick = {
                                            navController.navigateTo(
                                                FavoriteScreenDestination
                                            )
                                        },
                                        icon = {
                                            Icon(
                                                Icons.BookmarkBar,
                                                contentDescription = null
                                            )
                                        },
                                        label = { Text("Избранное") }
                                    )
                                    ThemedNavigationBarItem(
                                        selected = currentRoute == AccountScreenDestination.route,
                                        onClick = {
                                            navController.navigateTo(
                                                AccountScreenDestination
                                            )
                                        },
                                        icon = { Icon(Icons.Account, contentDescription = null) },
                                        label = { Text("Аккаунт") }
                                    )
                                }
                            }
                        }
                    ) { innerPadding ->
                        DestinationsNavHost(
                            navGraph = MainNavGraph(firstLaunch.value),
                            startRoute = OnBoardingScreenDestination,
                            engine = engine,
                            navController = navController,
                            dependenciesContainerBuilder = {
                                dependency(currentNavigator())
                            },
                            modifier = Modifier.padding(
                                if (currentRoute !in setOf(
                                        OnBoardingScreenDestination.route,
                                        LoginScreenDestination.route
                                    )
                                ) {
                                    PaddingValues(bottom = innerPadding.calculateBottomPadding())
                                } else {
                                    PaddingValues()
                                }
                            )
                        )
                    }
                }
            }
        }
    }
}


class MainNavGraph(firstLaunch: Boolean) : NavGraphSpec {
    override val route = "root"

    override val startRoute = LoginScreenDestination

    override val destinationsByRoute = listOf(
        OnBoardingScreenDestination,
        LoginScreenDestination,
        MainScreenDestination,
        FavoriteScreenDestination,
        AccountScreenDestination
    ).associateBy { it.route }
}

fun DestinationScope<*>.currentNavigator(): CommonNavGraphNavigator {
    return CommonNavGraphNavigator(navController)
}

class CommonNavGraphNavigator(
    private val navController: NavController,
) : OnboardingNavigator,
    LoginNavigator,
    MainNavigator,
    FavoriteNavigator {

    override fun navigateToLogin() {
        navController.navigateTo(LoginScreenDestination)
    }

    override fun navigateToMain() {
        navController.navigateTo(MainScreenDestination)
    }

    override fun navigateToCourse(id: Int) {
        // TODO
    }
}