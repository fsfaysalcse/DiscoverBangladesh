package me.fsfaysalcse.discoverbd.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.fsfaysalcse.discoverbd.ui.model.Category
import me.fsfaysalcse.discoverbd.ui.theme.OrangeMain
import me.fsfaysalcse.discoverbd.ui.theme.getNunitoFont
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomeCategory(
    category: Category
) {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(65.dp)
                .background(
                    color = OrangeMain.copy(0.2f),
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Center
        ) {
            Icon(
                painter = painterResource(category.icon),
                contentDescription = null,
                modifier = Modifier.size(40.dp, 40.dp)
            )
        }


        Text(
            text = category.name,
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = 14.sp,
            fontFamily = getNunitoFont(),
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 5.dp)
        )
    }
}