package me.fsfaysalcse.discoverbd.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.bg_drawer
import me.fsfaysalcse.discoverbd.ui.model.DRAWER_ITEM
import me.fsfaysalcse.discoverbd.ui.model.Drawer
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import me.fsfaysalcse.discoverbd.ui.theme.getProductSansFont
import me.fsfaysalcse.discoverbd.ui.widgets.DrawerItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawerScreen(
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ){

        Image(
            painter = painterResource(Res.drawable.bg_drawer),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .statusBarsPadding()
                .padding(vertical = 24.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .align(Alignment.TopCenter),
        ) {

            Text(
                text = "Hey, Faysal Hossain".uppercase(),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                fontSize = 16.sp,
                letterSpacing = 2.sp,
                fontFamily = getNunitoFont(),
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Box(
                    modifier = Modifier.height(2.dp).width(20.dp).background(
                        color = MaterialTheme.colorScheme.onSurface,
                        shape = CircleShape
                    )
                )

                Text(
                    text = "Good Evening",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 23.sp,
                    fontFamily = getProductSansFont(),
                    fontWeight = FontWeight.Bold,
                    lineHeight = 32.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )

            }


        }


        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            var selectedDrawerState by rememberSaveable {
                mutableIntStateOf(1)
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                DRAWER_ITEM.forEach { drawer: Drawer ->
                    val isSelected = drawer.id == selectedDrawerState
                    DrawerItem(
                        isSelected = isSelected,
                        drawer = drawer,
                        onItemClick = {
                            selectedDrawerState = drawer.id
                        }
                    )
                }
            }
        }


        Text(
            text = "Discover Bangladesh\nv1.0.0".uppercase(),
            color = Color.White,
            fontSize = 10.sp,
            letterSpacing = 2.sp,
            lineHeight = 20.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp)
        )
    }



}