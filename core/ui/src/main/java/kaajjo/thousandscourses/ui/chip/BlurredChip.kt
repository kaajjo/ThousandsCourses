package kaajjo.thousandscourses.ui.chip

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.HazeTint
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.materials.ExperimentalHazeMaterialsApi
import dev.chrisbanes.haze.materials.HazeMaterials

@OptIn(ExperimentalHazeMaterialsApi::class)
@Composable
fun BlurredChip(
    isHighlighted: Boolean = false,
    hazeState: HazeState,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Row(
        modifier = modifier
            .background(
                color = if (isHighlighted) Color(0xFF12B956) else Color(0x32333A4D),
                shape = RoundedCornerShape(48.dp)
            )
            .clip(RoundedCornerShape(48.dp))
            .hazeEffect(
                state = hazeState, style = HazeMaterials.ultraThin().copy(
                    blurRadius = 16.dp, tints = listOf(HazeTint(color = Color(0xCF191a1e)))
                )
            )
            .padding(horizontal = 28.dp, vertical = 18.dp)

    ) {
        CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.titleMedium) {
            content()
        }
    }
}