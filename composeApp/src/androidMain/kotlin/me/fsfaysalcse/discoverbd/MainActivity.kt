package me.fsfaysalcse.discoverbd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import me.fsfaysalcse.discoverbd.ui.screens.DiscoverFreedomScreen
import me.fsfaysalcse.discoverbd.ui.screens.DrawerScreen
import me.fsfaysalcse.discoverbd.ui.screens.HomeScreen
import me.fsfaysalcse.discoverbd.ui.theme.DiscoverBangladeshTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppAndroidPreview() {
    DiscoverBangladeshTheme {
        HomeScreen()
    }

}