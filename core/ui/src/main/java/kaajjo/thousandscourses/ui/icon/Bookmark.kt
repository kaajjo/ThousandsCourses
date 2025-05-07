package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Bookmark: ImageVector
    get() {
        if (_Bookmark != null) {
            return _Bookmark!!
        }
        _Bookmark = ImageVector.Builder(
            name = "Bookmark",
            defaultWidth = 16.dp,
            defaultHeight = 16.dp,
            viewportWidth = 16f,
            viewportHeight = 16f
        ).apply {
            path(fill = SolidColor(Color(0xFFF2F2F3))) {
                moveTo(5.332f, 1.343f)
                curveTo(3.631f, 1.343f, 2.665f, 2.307f, 2.665f, 4.007f)
                verticalLineTo(13.998f)
                curveTo(2.665f, 14.476f, 3.142f, 14.811f, 3.582f, 14.623f)
                lineTo(7.998f, 12.729f)
                lineTo(12.394f, 14.623f)
                curveTo(12.835f, 14.811f, 13.332f, 14.476f, 13.332f, 13.998f)
                verticalLineTo(4.007f)
                curveTo(13.332f, 2.26f, 12.462f, 1.343f, 10.665f, 1.343f)
                horizontalLineTo(5.332f)
                close()
                moveTo(5.332f, 2.675f)
                horizontalLineTo(10.665f)
                curveTo(11.709f, 2.675f, 11.998f, 2.98f, 11.998f, 4.007f)
                verticalLineTo(12.999f)
                lineTo(8.248f, 11.396f)
                curveTo(8.08f, 11.325f, 7.895f, 11.325f, 7.728f, 11.396f)
                lineTo(3.999f, 12.999f)
                verticalLineTo(4.007f)
                curveTo(3.999f, 3.043f, 4.366f, 2.675f, 5.332f, 2.675f)
                close()
            }
        }.build()

        return _Bookmark!!
    }

@Suppress("ObjectPropertyName")
private var _Bookmark: ImageVector? = null