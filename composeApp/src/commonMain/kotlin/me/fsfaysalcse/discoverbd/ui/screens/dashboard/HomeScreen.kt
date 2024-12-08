package me.fsfaysalcse.discoverbd.ui.screens.dashboard

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import me.fsfaysalcse.discoverbd.ui.model.CATEGORIES
import me.fsfaysalcse.discoverbd.ui.model.PACES2
import me.fsfaysalcse.discoverbd.ui.model.PLACES
import me.fsfaysalcse.discoverbd.ui.navigation.Screen
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import me.fsfaysalcse.discoverbd.ui.widgets.HomeCategory
import me.fsfaysalcse.discoverbd.ui.widgets.HomeSearchBar
import me.fsfaysalcse.discoverbd.ui.widgets.HorizontalPageCard
import me.fsfaysalcse.discoverbd.ui.widgets.PlaceVerticalCard


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
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
                TrendingSection(
                    navController = navController
                )
            }

            item { Spacer(Modifier.statusBarsPadding().size(30.dp)) }
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
    }

    Row(
        modifier = Modifier
            .padding(vertical = 10.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .align(CenterHorizontally),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->

            val animateWidth by animateDpAsState(
                targetValue = if (pagerState.currentPage == iteration) 30.dp else 20.dp
            )

            val animateColor by animateColorAsState(
                targetValue =  if (pagerState.currentPage == iteration) OrangeMain else Color.Gray
            )


            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(
                        color = animateColor,
                        shape = CircleShape
                    )
                    .size(height = 5.dp, width = animateWidth)
            )
        }
    }

}

@Composable
fun ColumnScope.TrendingSection(navController: NavHostController?) {
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
            PlaceVerticalCard(
                place = PLACES[index],
                onPlaceClick = {
                    navController?.navigate(Screen.PlaceDetails.route)
                }
            )
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
