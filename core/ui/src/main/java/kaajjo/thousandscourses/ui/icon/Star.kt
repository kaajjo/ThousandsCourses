package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Star: ImageVector
    get() {
        if (_Test != null) {
            return _Test!!
        }
        _Test = ImageVector.Builder(
            name = "Star",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF12B956))) {
                moveTo(12.024f, 2.442f)
                curveTo(11.452f, 2.442f, 10.87f, 2.796f, 10.524f, 3.504f)
                lineTo(8.4f, 7.876f)
                lineTo(3.56f, 8.564f)
                curveTo(2.002f, 8.78f, 1.498f, 10.308f, 2.622f, 11.406f)
                lineTo(6.12f, 14.81f)
                lineTo(5.308f, 19.59f)
                curveTo(5.042f, 21.136f, 6.324f, 22.072f, 7.714f, 21.338f)
                curveTo(8.25f, 21.054f, 11.01f, 19.624f, 12.024f, 19.09f)
                lineTo(16.334f, 21.338f)
                curveTo(17.724f, 22.072f, 19.012f, 21.138f, 18.738f, 19.59f)
                lineTo(17.896f, 14.81f)
                lineTo(21.394f, 11.406f)
                curveTo(22.524f, 10.312f, 22.046f, 8.784f, 20.488f, 8.564f)
                lineTo(15.616f, 7.876f)
                lineTo(13.522f, 3.504f)
                curveTo(13.178f, 2.796f, 12.594f, 2.442f, 12.024f, 2.442f)
                close()
            }
        }.build()

        return _Test!!
    }

@Suppress("ObjectPropertyName")
private var _Test: ImageVector? = null