package me.fsfaysalcse.discoverbd

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import me.fsfaysalcse.discoverbd.ui.screens.DiscoverFreedomScreen
import me.fsfaysalcse.discoverbd.ui.screens.HomeScreen
import me.fsfaysalcse.discoverbd.ui.theme.DiscoverBangladeshTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    DiscoverBangladeshTheme {
        HomeScreen()
    }
}