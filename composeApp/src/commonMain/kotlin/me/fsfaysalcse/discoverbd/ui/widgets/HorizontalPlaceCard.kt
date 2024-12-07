package me.fsfaysalcse.discoverbd.ui.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import discoverbangladesh.composeapp.generated.resources.Res
import discoverbangladesh.composeapp.generated.resources.bg_splash
import me.fsfaysalcse.discoverbd.ui.model.Place
import org.jetbrains.compose.resources.painterResource

@Composable
fun HorizontalPageCard(place: Place) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        CoilImage(
            imageModel = { place.image },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            ),
            previewPlaceholder = painterResource(Res.drawable.bg_splash),
            modifier = Modifier.fillMaxSize()
        )
    }
}