package kaajjo.thousandscourses.ui.card

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.materials.HazeMaterials
import dev.chrisbanes.haze.rememberHazeState
import kaajjo.thousandscourses.ui.R
import kaajjo.thousandscourses.ui.ThousandsCoursesTheme
import kaajjo.thousandscourses.ui.icon.ArrowRight
import kaajjo.thousandscourses.ui.icon.Bookmark
import kaajjo.thousandscourses.ui.icon.Star
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CourseCard(
    title: String,
    description: String,
    price: Int,
    onClick: () -> Unit,
    onBookmarkClick: () -> Unit,
    rating: Float,
    date: LocalDate,
    marked: Boolean,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF24252A)
        ),
        shape = MaterialTheme.shapes.large
    ) {
        val hazeState = rememberHazeState()
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2.75f)
                .clip(MaterialTheme.shapes.medium)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .hazeSource(hazeState)
            ) {
                // Use Coil and load images by link with real data
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2.75f),
                    painter = painterResource(id = R.drawable.cover),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter
                )
            }
            /*Box(
                modifier = Modifier
                    .matchParentSize()
                    .hazeSource(hazeState)
                    .background(
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Yellow,
                                Color.Green,
                                Color.Blue,
                                Color.Green,
                                Color.Red,
                                Color.Yellow,
                                Color.Green,
                                Color.Blue,
                                Color.Green,
                            ),
                            center = Offset(65f, 120f),
                        )
                    )
            )*/
            BlurredSmallChip(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                text = "",
                icon = {
                    AnimatedContent(marked) { state ->
                        if (state) {
                            Icon(
                                imageVector = Icons.Filled.Bookmark,
                                contentDescription = null,
                                tint = Color(0xFF48B555),
                                modifier = Modifier.size(16.dp)
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Bookmark,
                                contentDescription = null,
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                },
                hazeState = hazeState,
                onClick = onBookmarkClick
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(8.dp)
            ) {
                BlurredSmallChip(
                    text = "$rating",
                    icon = {
                        Icon(
                            imageVector = Icons.Star,
                            contentDescription = null,
                            tint = Color.Green,
                            modifier = Modifier.size(24.dp)
                        )
                    },
                    hazeState = hazeState
                )
                Spacer(modifier = Modifier.width(4.dp))
                BlurredSmallChip(
                    text = DateTimeFormatter.ofPattern("d MMMM yyyy").format(date),
                    hazeState = hazeState
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium
                    .copy(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 16.sp),
                color = LocalContentColor.current.copy(alpha = 0.75f)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$price ₽",
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
                )
                TextButton(
                    onClick = onClick,
                    colors = ButtonDefaults.textButtonColors(contentColor = Color(0xFF12B956))
                ) {
                    Text(
                        text = "Подробнее",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Icon(
                        imageVector = Icons.ArrowRight,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun BlurredSmallChip(
    text: String,
    hazeState: HazeState,
    modifier: Modifier = Modifier,
    icon: @Composable (RowScope.() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .clip(CircleShape)
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .hazeEffect(
                state = hazeState, style = HazeMaterials.ultraThin().copy(
                    blurRadius = 4.dp,
                    noiseFactor = 0.05f,
                )
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (icon != null) {
            icon()
            if (text.isNotEmpty()) {
                Spacer(modifier = Modifier.width(4.dp))
            }
        }
        Text(
            text = text,
        )
    }
}


@Preview
@Composable
fun CourseCardPreview() {
    ThousandsCoursesTheme {
        Surface {
            CourseCard(
                modifier = Modifier.padding(12.dp),
                title = "Java-разработчик с нуля",
                description = "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
                price = 999,
                onClick = {},
                rating = 4.9f,
                marked = false,
                date = LocalDate.now(),
                onBookmarkClick = TODO()
            )
        }
    }
}