package me.fsfaysalcse.discoverbd.ui.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.calculateTargetValue
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.ic_close_drawer
import discoverbangladesh.composeapp.generated.resources.ic_my_location
import discoverbangladesh.composeapp.generated.resources.ic_nav_menu
import discoverbangladesh.composeapp.generated.resources.ic_person
import kotlinx.coroutines.launch
import me.fsfaysalcse.discoverbd.ui.model.CATEGORIES
import me.fsfaysalcse.discoverbd.ui.model.DrawerState
import me.fsfaysalcse.discoverbd.ui.model.PACES2
import me.fsfaysalcse.discoverbd.ui.model.PLACES
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import me.fsfaysalcse.discoverbd.ui.widgets.HomeCategory
import me.fsfaysalcse.discoverbd.ui.widgets.HomeSearchBar
import me.fsfaysalcse.discoverbd.ui.widgets.HorizontalPageCard
import me.fsfaysalcse.discoverbd.ui.widgets.PlaceVerticalCard
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val scope = rememberCoroutineScope()
    var drawerState by remember { mutableStateOf(DrawerState.CLOSED) }

    val drawerWidth = 700f

    val translationX = remember {
        Animatable(0f)
    }

    translationX.updateBounds(0f, drawerWidth)

    val draggableState = rememberDraggableState(onDelta = { dragAmount ->
        scope.launch {
            translationX.snapTo(translationX.value + dragAmount)
        }
    })

    val decay = rememberSplineBasedDecay<Float>()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        DrawerScreen(modifier = Modifier)

        Box(
            modifier = Modifier.fillMaxSize()
                .graphicsLayer {
                    this.translationX = translationX.value
                    val scale = lerp(1f, 0.8f, translationX.value / drawerWidth)
                    this.scaleX = scale
                    this.scaleY = scale
                    shape = RoundedCornerShape(30.dp)
                    clip = true
                }.draggable(
                    state = draggableState,
                    orientation = Orientation.Horizontal,
                    onDragStopped = { velocity: Float ->
                        val decayX = decay.calculateTargetValue(
                            translationX.value,
                            velocity
                        )
                        scope.launch {
                            val targetX = if (decayX > drawerWidth * 0.5f) {
                                drawerWidth
                            } else {
                                0f
                            }

                            val canReachTargetWithDecay =
                                (decayX > targetX && targetX == drawerWidth || (decayX < targetX && targetX == 0f))

                            if (canReachTargetWithDecay) {
                                translationX.animateDecay(
                                    initialVelocity = velocity,
                                    animationSpec = decay
                                )
                            } else {
                                translationX.animateTo(
                                    targetValue = targetX,
                                    initialVelocity = velocity
                                )
                            }
                            drawerState = if (targetX == drawerWidth) {
                                DrawerState.OPEN
                            } else {
                                DrawerState.CLOSED
                            }
                        }

                    }
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
                    .statusBarsPadding()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 10.dp),
                    verticalAlignment = CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        scope.launch {
                            if (drawerState == DrawerState.OPEN) {
                                translationX.animateTo(0f)
                            } else {
                                translationX.animateTo(drawerWidth)
                            }
                            drawerState = if (drawerState == DrawerState.OPEN) {
                                DrawerState.CLOSED
                            } else {
                                DrawerState.OPEN
                            }
                        }
                    }
                    ) {

                        val icon = if (drawerState == DrawerState.OPEN){
                            Res.drawable.ic_close_drawer
                        }else{
                            Res.drawable.ic_nav_menu
                        }

                        Icon(
                            painter = painterResource(Res.drawable.ic_nav_menu),
                            contentDescription = null,
                            modifier = Modifier.size(33.dp, 21.dp),
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Row(
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.ic_my_location),
                            contentDescription = null,
                            modifier = Modifier.height(20.dp),
                            tint = OrangeMain
                        )

                        Text(
                            text = "Dhaka, Bangladesh",
                            color = MaterialTheme.colorScheme.onSurface,
                            fontSize = 14.sp,
                            fontFamily = getNunitoFont(),
                            fontWeight = FontWeight.Light,
                            modifier = Modifier
                                .align(CenterVertically)
                        )
                    }

                    Image(
                        painter = painterResource(Res.drawable.ic_person),
                        contentDescription = null,
                        modifier = Modifier.size(50.dp)
                            .clip(CircleShape)
                            .border(
                                brush = Brush.verticalGradient(
                                    listOf(
                                        Color.Gray,
                                        OrangeMain
                                    )
                                ),
                                shape = CircleShape,
                                width = 2.dp
                            ),
                        contentScale = ContentScale.FillBounds
                    )
                }



                LazyColumn(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    item(key = "home_search") {
                        var searchQuery by remember { mutableStateOf("") }

                        HomeSearchBar(
                            text = searchQuery,
                            onTextChange = { searchQuery = it },
                            onSearchClick = { /* Handle search action */ }
                        )
                    }
                    item(key = "home_category") {
                        HomeCategorySection()
                    }

                    item(
                        key = "most_rated_section"
                    ) {
                        MostRatedSection()
                    }

                    item(key = "trending_section") {
                        TrendingSection()
                    }
                }
            }
        }
    }


}

@Composable
fun ColumnScope.MostRatedSection() {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Most Rated",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }

    val pagerState = rememberPagerState(pageCount = {
        PACES2.size
    })

    Box(
        modifier = Modifier
            .padding(top = 12.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clip(RoundedCornerShape(16.dp))
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.height(130.dp).fillMaxWidth()
        ) { index ->
            HorizontalPageCard(PACES2[index])
        }

        Row(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->

                val selectedWidth = if (pagerState.currentPage == iteration) 20.dp else 10.dp
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(
                            color = color,
                            shape = CircleShape
                        )
                        .size(height = 3.dp, width = selectedWidth)
                )
            }
        }
    }

}

@Composable
fun ColumnScope.TrendingSection() {
    Row(
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Tending Visit",
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 16.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )

        Text(
            text = "View All",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            fontSize = 16.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }

    LazyRow(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(Modifier.width(8.dp)) }

        items(PLACES.size) { index ->
            PlaceVerticalCard(PLACES[index])
        }

        item { Spacer(Modifier.width(16.dp)) }
    }
}

@Composable
fun ColumnScope.HomeCategorySection() {
    Text(
        text = "Popular Categories",
        color = MaterialTheme.colorScheme.onSurface,
        fontSize = 16.sp,
        fontFamily = getNunitoFont(),
        fontWeight = FontWeight.Bold,
        lineHeight = 32.sp,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    )

    Row(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CATEGORIES.forEach {
            HomeCategory(it)
        }
    }
}
