package me.fsfaysalcse.discoverbd.ui.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.bg_splash
import discoverbangladesh.composeapp.generated.resources.ic_arrow_back
import discoverbangladesh.composeapp.generated.resources.ic_navigation
import me.fsfaysalcse.discoverbd.ui.model.PACES2
import me.fsfaysalcse.discoverbd.ui.model.PACES3
import me.fsfaysalcse.discoverbd.ui.model.PLACES
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import me.fsfaysalcse.discoverbd.ui.theme.getOpenSansFont
import org.jetbrains.compose.resources.painterResource

@Composable
fun PlaceDetailsScreen(
    navController: NavHostController? = null
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        val pagerState = rememberPagerState(pageCount = {
            PACES3.take(3).size
        })

        // Automatically slide the pager every 3 seconds
        LaunchedEffect(pagerState) {
            while (true) {
                kotlinx.coroutines.delay(3000)
                val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                pagerState.animateScrollToPage(nextPage)
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { index ->

            CoilImage(
                imageModel = { PACES3[index].image },
                imageOptions = ImageOptions(
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.Center
                ),
                previewPlaceholder = painterResource(Res.drawable.bg_splash),
                modifier = Modifier.fillMaxSize()
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth()
                .height(400.dp)
                .align(Alignment.BottomEnd)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            OrangeMain.copy(0.1f),
                            OrangeMain.copy(0.2f),
                            OrangeMain.copy(0.3f),
                            OrangeMain.copy(0.4f),
                            OrangeMain.copy(0.5f)
                        )
                    )
                )
        )


        Box(
            modifier = Modifier
                .statusBarsPadding()
                .padding(horizontal = 16.dp, vertical = 30.dp)
                .size(50.dp)
                .background(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(8.dp)
                ).clickable {
                    navController?.navigateUp()
                }
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_arrow_back),
                contentDescription = "Arrow",
                tint = MaterialTheme.colorScheme.onSurface
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth()
                .navigationBarsPadding()
                .padding(32.dp)
                .align(Alignment.BottomEnd),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            Text(
                text = "Cox's Bazar",
                color = Color.White,
                fontSize = 28.sp,
                fontFamily = getNunitoFont(),
                fontWeight = FontWeight.Bold,
                lineHeight = 32.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier
            )

            Text(
                text = "Cox's Bazar, Bangladesh, is home to the world's longest unbroken sea beach, stretching 120 km along the Bay of Bengal. It's a popular tourist destination with stunning beaches and vibrant markets.",
                color = Color.White.copy(alpha = 0.8f),
                fontFamily = getOpenSansFont(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 22.sp,
                modifier = Modifier
            )

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .wrapContentHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                repeat(pagerState.pageCount) { iteration ->

                    val animateWidth by animateDpAsState(
                        targetValue = if (pagerState.currentPage == iteration) 30.dp else 20.dp
                    )

                    val animateColor by animateColorAsState(
                        targetValue = if (pagerState.currentPage == iteration) OrangeMain else Color.Gray
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

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_navigation),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = "23.6 km, North",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontFamily = getOpenSansFont(),
                        color = Color.White
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = OrangeMain
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Navigate Me",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = getNunitoFont(),
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp,
                    textAlign = TextAlign.Start
                )
            }

        }
    }
}