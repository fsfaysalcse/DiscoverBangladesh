package me.fsfaysalcse.discoverbd

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.fsfaysalcse.discoverbd.ui.navigation.Screen
import me.fsfaysalcse.discoverbd.ui.screens.DashboardScreen
import me.fsfaysalcse.discoverbd.ui.screens.OnBoardingScreen
import me.fsfaysalcse.discoverbd.ui.screens.PlaceDetailsScreen
import me.fsfaysalcse.discoverbd.ui.theme.DiscoverBangladeshTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    DiscoverBangladeshTheme {
        val navController: NavHostController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Screen.OnBoarding.route,
            modifier = Modifier.fillMaxSize()
        ) {

            composable(route = Screen.OnBoarding.route) {
                OnBoardingScreen(
                    navController = navController
                )
            }

            composable(route = Screen.Dashboard.route) {
                DashboardScreen(
                    navController = navController
                )
            }

            composable(route = Screen.PlaceDetails.route) {
                PlaceDetailsScreen(
                    navController = navController
                )
            }
        }
    }
}