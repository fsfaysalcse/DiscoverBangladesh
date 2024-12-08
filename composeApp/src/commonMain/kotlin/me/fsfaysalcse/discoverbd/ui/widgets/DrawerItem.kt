package me.fsfaysalcse.discoverbd.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.fsfaysalcse.discoverbd.ui.model.Drawer
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import org.jetbrains.compose.resources.painterResource

@Composable
fun DrawerItem(
    isSelected: Boolean,
    drawer: Drawer,
    onItemClick: () -> Unit
) {

    val selectedRadius = if (isSelected) 65.dp else 0.dp
    val selectedBackground = if (isSelected) OrangeMain else Color.Transparent
    val selectedColor = if (isSelected){
        Color.White
    }else{
        OrangeMain
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = selectedBackground,
                shape = RoundedCornerShape(
                    topStart = selectedRadius,
                    bottomStart = selectedRadius
                )
            )
            .clickable {
                onItemClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Box(
            modifier = Modifier
                .size(50.dp)
                .background(
                    color = OrangeMain,
                    shape = CircleShape
                ).padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(drawer.icon),
                contentDescription = "Arrow",
                tint = Color.White
            )
        }

        Text(
            text = drawer.name.uppercase(),
            color = selectedColor,
            fontSize = 20.sp,
            letterSpacing = 3.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 13.dp)
                .align(Alignment.CenterVertically)
        )
    }
}
