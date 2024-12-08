package me.fsfaysalcse.discoverbd.ui.model

import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.ic_double_arrow
import org.jetbrains.compose.resources.DrawableResource

data class Drawer(
    val id: Int,
    val name: String,
    val icon: DrawableResource
)


val DRAWER_ITEM = listOf(
    Drawer(
        id = 1,
        name = "Home",
        icon = Res.drawable.ic_double_arrow
    ),
    Drawer(
        id = 2,
        name = "Maps",
        icon = Res.drawable.ic_double_arrow
    ),
    Drawer(
        id = 3,
        name = "Discover",
        icon = Res.drawable.ic_double_arrow
    ),
    Drawer(
        id = 4,
        name = "Settings",
        icon = Res.drawable.ic_double_arrow
    )

)
