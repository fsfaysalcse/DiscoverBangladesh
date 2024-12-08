package me.fsfaysalcse.discoverbd.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.bg_splash
import discoverbangladesh.composeapp.generated.resources.ic_double_arrow
import me.fsfaysalcse.discoverbd.ui.navigation.Screen
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import me.fsfaysalcse.discoverbd.ui.theme.getOpenSansFont
import org.jetbrains.compose.resources.painterResource

@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val animationValue = animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 1000)
    ).value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF6B3A99),
                        Color(0xFFFF7043)
                    )
                )
            )
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_splash),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .align(Alignment.BottomCenter)
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier.height(2.dp).width(30.dp).background(
                            color = Color.White,
                            shape = CircleShape
                        )
                    )

                    Text(
                        text = "HELLO",
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp,
                        letterSpacing = 2.sp,
                        fontFamily = getNunitoFont(),
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Discover Bangladesh",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontFamily = getNunitoFont(),
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp,
                    modifier = Modifier.alpha(animationValue)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Take a city break and discover the beauty of nature. Unwind without any worries and find out what freedom really means.",
                    color = Color.White.copy(alpha = 0.8f),
                    fontFamily = getOpenSansFont(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 22.sp,
                    modifier = Modifier.alpha(animationValue)
                )
            }

            Row(
                modifier = Modifier.padding(top = 30.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Read more",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontFamily = getNunitoFont(),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                )

                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .background(
                            color = OrangeMain,
                            shape = RoundedCornerShape(8.dp)
                        ).clickable {
                            navController.navigate(Screen.Dashboard.route) {
                                popUpTo(Screen.OnBoarding.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(15.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ic_double_arrow),
                        contentDescription = "Arrow",
                        tint = Color.White
                    )
                }
            }
        }
    }
}
