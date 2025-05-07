package kaajjo.thousandscourses.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.android.material.chip.Chip
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeSource
import kaajjo.thousandscourses.ui.chip.BlurredChip


// Обычная строка категорий без эффектов
@Composable
fun RegularCategoryRow(
    categories: List<Pair<String, Boolean>>,
    hazeState: HazeState,
    initialOffset: Int,
    zIndex: Float = 0f
) {
    LazyRow(
        modifier = Modifier.zIndex(zIndex),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = rememberLazyListState(initialFirstVisibleItemScrollOffset = initialOffset)
    ) {
        items(categories) { (text, isHighlighted) ->
            BlurredChip(
                isHighlighted = isHighlighted,
                hazeState = hazeState,
                modifier = Modifier.hazeSource(hazeState, if (isHighlighted) 0f else 1f)
            ) {
                Text(text = text)
            }
        }
    }
}

// Строка категорий с эффектом наклона
@Composable
fun CategoryRowWithTilt(
    categories: List<Pair<String, Boolean>>,
    hazeState: HazeState,
    initialOffset: Int,
    tiltAngle: Float,
    translationY: Dp,
    invertZIndex: Boolean = false,
    zIndex: Float = -1f
) {
    LazyRow(
        modifier = Modifier.zIndex(zIndex),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = rememberLazyListState(initialFirstVisibleItemScrollOffset = initialOffset)
    ) {
        items(categories) { (text, isHighlighted) ->
            BlurredChip(
                isHighlighted = isHighlighted,
                hazeState = hazeState,
                modifier = Modifier
                    .zIndex(
                        if (isHighlighted) {
                            if (invertZIndex) -1f else 0f
                        } else 1f
                    )
                    .graphicsLayer {
                        rotationZ = when {
                            isHighlighted -> tiltAngle
                            else -> 0f
                        }
                        this.translationY = when {
                            isHighlighted -> translationY.toPx()
                            else -> 0f
                        }
                    }
                    .hazeSource(
                        hazeState,
                        if (isHighlighted) 0f else 1f
                    )
            ) {
                Text(text = text)
            }
        }
    }
}

// Специальная строка с подложкой для элементов
@Composable
fun SpecialCategoryRow(
    categories: List<Pair<String, Boolean>>,
    hazeState: HazeState,
    initialOffset: Int
) {
    LazyRow(
        modifier = Modifier.zIndex(-1f),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        state = rememberLazyListState(initialFirstVisibleItemScrollOffset = initialOffset)
    ) {
        items(categories) { (text, isHighlighted) ->
            Box {
                if (isHighlighted) {
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .alpha(0f)
                            .offset(y = -(10).dp, x = 5.dp)
                            .rotate(15f)
                            .hazeSource(hazeState, 0f)
                            .background(Color.Green, RoundedCornerShape(36.dp))
                    )
                }
                BlurredChip(
                    isHighlighted = isHighlighted,
                    hazeState = hazeState,
                    modifier = Modifier
                        .zIndex(if (isHighlighted) -1f else 1f)
                        .graphicsLayer {
                            this.translationY = when {
                                isHighlighted -> -15.dp.toPx()
                                else -> 0f
                            }
                            rotationZ = when {
                                isHighlighted -> -15f
                                else -> 0f
                            }
                        }
                        .hazeSource(hazeState, if (isHighlighted) 0f else 1f)
                ) {
                    Text(text = text)
                }
            }
        }
    }
}