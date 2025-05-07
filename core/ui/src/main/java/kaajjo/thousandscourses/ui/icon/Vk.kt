package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Vk: ImageVector
    get() {
        if (_Test != null) {
            return _Test!!
        }
        _Test = ImageVector.Builder(
            name = "Vk",
            defaultWidth = 50.dp,
            defaultHeight = 40.dp,
            viewportWidth = 50f,
            viewportHeight = 40f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(26.321f, 28f)
                curveTo(17.538f, 28f, 12.207f, 21.989f, 12f, 12f)
                horizontalLineTo(16.449f)
                curveTo(16.587f, 19.338f, 19.972f, 22.451f, 22.566f, 23.086f)
                verticalLineTo(12f)
                horizontalLineTo(26.831f)
                verticalLineTo(18.331f)
                curveTo(29.333f, 18.057f, 31.951f, 15.177f, 32.833f, 12f)
                horizontalLineTo(37.026f)
                curveTo(36.354f, 15.909f, 33.505f, 18.789f, 31.488f, 19.977f)
                curveTo(33.505f, 20.938f, 36.749f, 23.452f, 38f, 28f)
                horizontalLineTo(33.389f)
                curveTo(32.416f, 24.96f, 30.028f, 22.605f, 26.831f, 22.285f)
                verticalLineTo(28f)
                horizontalLineTo(26.321f)
                close()
            }
        }.build()

        return _Test!!
    }

@Suppress("ObjectPropertyName")
private var _Test: ImageVector? = null
