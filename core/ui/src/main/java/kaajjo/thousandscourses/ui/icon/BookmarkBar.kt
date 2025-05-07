package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.BookmarkBar: ImageVector
    get() {
        if (_BookmarkBar != null) {
            return _BookmarkBar!!
        }
        _BookmarkBar = ImageVector.Builder(
            name = "BookmarkBar",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF12B956))) {
                moveTo(7.998f, 2.014f)
                curveTo(5.446f, 2.014f, 3.998f, 3.461f, 3.998f, 6.011f)
                verticalLineTo(20.997f)
                curveTo(3.998f, 21.715f, 4.713f, 22.217f, 5.373f, 21.934f)
                lineTo(11.998f, 19.093f)
                lineTo(18.592f, 21.934f)
                curveTo(19.252f, 22.217f, 19.998f, 21.715f, 19.998f, 20.997f)
                verticalLineTo(6.011f)
                curveTo(19.998f, 3.39f, 18.693f, 2.014f, 15.998f, 2.014f)
                horizontalLineTo(7.998f)
                close()
                moveTo(7.998f, 4.012f)
                horizontalLineTo(15.998f)
                curveTo(17.564f, 4.012f, 17.998f, 4.47f, 17.998f, 6.011f)
                verticalLineTo(19.499f)
                lineTo(12.373f, 17.095f)
                curveTo(12.121f, 16.987f, 11.843f, 16.987f, 11.592f, 17.095f)
                lineTo(5.998f, 19.499f)
                verticalLineTo(6.011f)
                curveTo(5.998f, 4.564f, 6.55f, 4.012f, 7.998f, 4.012f)
                close()
            }
        }.build()

        return _BookmarkBar!!
    }

@Suppress("ObjectPropertyName")
private var _BookmarkBar: ImageVector? = null