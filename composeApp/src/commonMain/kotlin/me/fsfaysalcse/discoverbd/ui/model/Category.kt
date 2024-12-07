package me.fsfaysalcse.discoverbd.ui.model

import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.compose_multiplatform
import discoverbangladesh.composeapp.generated.resources.ic_camping
import discoverbangladesh.composeapp.generated.resources.ic_forest
import discoverbangladesh.composeapp.generated.resources.ic_lake
import discoverbangladesh.composeapp.generated.resources.ic_mountains
import org.jetbrains.compose.resources.DrawableResource

data class Category(
    val id: Int,
    val name: String,
    val icon: DrawableResource
)

val CATEGORIES = listOf(
    Category(
        id = 1,
        name = "Mountains",
        icon = Res.drawable.ic_mountains
    ),
    Category(
        id = 2,
        name = "Camping",
        icon = Res.drawable.ic_camping
    ),
    Category(
        id = 3,
        name = "Lake",
        icon = Res.drawable.ic_lake
    ),

    Category(
        id = 4,
        name = "Forest",
        icon = Res.drawable.ic_forest
    )
)