package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.ArrowRight: ImageVector
    get() {
        if (_IconName != null) {
            return _IconName!!
        }
        _IconName = ImageVector.Builder(
            name = "ArrowRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF12B956))) {
                moveTo(6.012f, 11.988f)
                curveTo(6.012f, 11.436f, 6.4605f, 10.989f, 7.0125f, 10.989f)
                horizontalLineTo(13.0125f)
                verticalLineTo(6.9885f)
                lineTo(18.012f, 11.988f)
                lineTo(13.0125f, 16.989f)
                verticalLineTo(12.9885f)
                horizontalLineTo(7.0125f)
                curveTo(6.4605f, 12.9885f, 6.012f, 12.54f, 6.012f, 11.988f)
                close()
            }
        }.build()

        return _IconName!!
    }

@Suppress("ObjectPropertyName")
private var _IconName: ImageVector? = null
