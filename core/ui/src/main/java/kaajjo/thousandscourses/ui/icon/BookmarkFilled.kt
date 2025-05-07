package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.BookmarkFilled: ImageVector
    get() {
        if (_BookmarkFilled != null) {
            return _BookmarkFilled!!
        }
        _BookmarkFilled = ImageVector.Builder(
            name = "BookmarkFilled",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(7.0f, 4.0f)
                lineTo(17.0f, 4.0f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19.0f, 6.0f)
                lineTo(19.0f, 14.0f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 17.0f, 16.0f)
                lineTo(7.0f, 16.0f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.0f, 14.0f)
                lineTo(5.0f, 6.0f)
                arcTo(2f, 2f, 0f, isMoreThanHalf = false, isPositiveArc = true, 7.0f, 4.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(5.0f, 6.0f)
                horizontalLineToRelative(1.0f)
                verticalLineToRelative(12.0f)
                horizontalLineToRelative(-1.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(11.0f, 15.0f)
                lineToRelative(1.0f, 2.0f)
                lineToRelative(-6.0f, 3.0f)
                lineToRelative(-1.0f, -2.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12.0f, 17.0f)
                lineToRelative(1.0f, -2.0f)
                lineToRelative(6.0f, 3.0f)
                lineToRelative(-1.0f, 2.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18.0f, 6.5f)
                horizontalLineToRelative(1.0f)
                verticalLineToRelative(12.0f)
                horizontalLineToRelative(-1.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(5.2f, 18.0f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.6f, 18.5f)
                lineTo(5.6f, 19.0f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.2f, 19.5f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 4.8f, 19.0f)
                lineTo(4.8f, 18.5f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 5.2f, 18.0f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF43B052)),
                stroke = SolidColor(Color(0xFF43B052)),
                strokeLineWidth = 0.3f,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(18.8f, 18.0f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 19.2f, 18.5f)
                lineTo(19.2f, 19.0f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18.8f, 19.5f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18.4f, 19.0f)
                lineTo(18.4f, 18.5f)
                arcTo(0.4f, 0.5f, 0f, isMoreThanHalf = false, isPositiveArc = true, 18.8f, 18.0f)
                close()
            }
        }.build()

        return _BookmarkFilled!!
    }

@Suppress("ObjectPropertyName")
private var _BookmarkFilled: ImageVector? = null