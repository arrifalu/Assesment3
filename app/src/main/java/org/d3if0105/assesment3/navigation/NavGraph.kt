package org.d3if0105.assesment3.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.d3if0105.assesment3.ui.screen.LandingScreen
import org.d3if0105.assesment3.ui.screen.MainScreen

sealed class Screen(val route: String) {
    object LandingScreen : Screen("landing_screen")
    object MainScreen : Screen("main_screen")
}

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.LandingScreen.route,
        modifier = modifier
    ) {
        composable(route = Screen.LandingScreen.route) {
            LandingScreen(navController = navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen()
        }
    }
}
