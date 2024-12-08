package me.fsfaysalcse.discoverbd.ui.navigation

sealed class Screen(val route: String) {
    data object OnBoarding : Screen("on_boarding")
    data object Dashboard : Screen("dashboard")
    data object PlaceDetails : Screen("place_details")
}