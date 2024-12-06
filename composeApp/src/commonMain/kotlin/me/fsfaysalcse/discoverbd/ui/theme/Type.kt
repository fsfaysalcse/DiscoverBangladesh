package me.fsfaysalcse.discoverbd.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.barlow_bold
import discoverbangladesh.composeapp.generated.resources.barlow_extra_bold
import discoverbangladesh.composeapp.generated.resources.barlow_regular
import discoverbangladesh.composeapp.generated.resources.nunito_nans_regular
import discoverbangladesh.composeapp.generated.resources.nunito_sans_bold
import discoverbangladesh.composeapp.generated.resources.nunito_sans_italic
import discoverbangladesh.composeapp.generated.resources.nunito_sans_light
import discoverbangladesh.composeapp.generated.resources.nunito_sans_medium
import discoverbangladesh.composeapp.generated.resources.open_sans_bold
import discoverbangladesh.composeapp.generated.resources.open_sans_light
import discoverbangladesh.composeapp.generated.resources.open_sans_regular
import discoverbangladesh.composeapp.generated.resources.product_sans_black
import discoverbangladesh.composeapp.generated.resources.product_sans_bold
import discoverbangladesh.composeapp.generated.resources.product_sans_light
import discoverbangladesh.composeapp.generated.resources.product_sans_medium
import discoverbangladesh.composeapp.generated.resources.product_sans_regular
import discoverbangladesh.composeapp.generated.resources.product_sans_thin
import org.jetbrains.compose.resources.Font

// Set of Material typography styles to start with

@Composable
fun getNunitoFont() = FontFamily(
    Font(Res.font.nunito_nans_regular, FontWeight.Normal),
    Font(Res.font.nunito_sans_bold, FontWeight.Bold),
    Font(Res.font.nunito_sans_light, FontWeight.Light),
    Font(Res.font.nunito_sans_medium, FontWeight.Medium),
    Font(Res.font.nunito_sans_italic, FontWeight.Thin)
)

@Composable
fun getBarlowFont() = FontFamily(
    Font(Res.font.barlow_regular, FontWeight.Normal),
    Font(Res.font.barlow_bold, FontWeight.Bold),
    Font(Res.font.barlow_extra_bold, FontWeight.ExtraBold),
)

@Composable
fun getOpenSansFont() = FontFamily(
    Font(Res.font.open_sans_regular, FontWeight.Normal),
    Font(Res.font.open_sans_bold, FontWeight.Bold),
    Font(Res.font.open_sans_light, FontWeight.Light)
)

@Composable
fun getProductSansFont() = FontFamily(
    Font(Res.font.product_sans_regular, FontWeight.Normal),
    Font(Res.font.product_sans_bold, FontWeight.Bold),
    Font(Res.font.product_sans_light, FontWeight.Light),
    Font(Res.font.product_sans_medium, FontWeight.Medium),
    Font(Res.font.product_sans_thin, FontWeight.Thin),
    Font(Res.font.product_sans_black, FontWeight.Black)
)
