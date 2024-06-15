package org.d3if0105.assesment3.ui.navigation

sealed class Screen(val route: String) {
    object LandingScreen : Screen("landing_screen")
    object MainScreen : Screen("main_screen")
}
