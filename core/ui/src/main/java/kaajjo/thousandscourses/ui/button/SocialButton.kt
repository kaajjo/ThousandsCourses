package kaajjo.thousandscourses.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kaajjo.thousandscourses.ui.icon.Ok
import kaajjo.thousandscourses.ui.icon.Vk

@Composable
fun OkSocialButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val gradientColors = listOf(Color(0xFFF98509), Color(0xFFF95D00))

    Box(
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .clickable(onClick = onClick)
            .background(
                brush = Brush.horizontalGradient(colors = gradientColors),
                shape = MaterialTheme.shapes.extraLarge
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Ok,
            contentDescription = null
        )
    }
}

@Composable
fun VkSocialButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(shape = MaterialTheme.shapes.extraLarge)
            .clickable(onClick = onClick)
            .background(
                color = Color(0xFF2683ED),
                shape = MaterialTheme.shapes.extraLarge
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            imageVector = Icons.Vk,
            contentDescription = null
        )
    }
}