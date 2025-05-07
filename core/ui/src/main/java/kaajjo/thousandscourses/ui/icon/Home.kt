package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Home: ImageVector
    get() {
        if (_Home != null) {
            return _Home!!
        }
        _Home = ImageVector.Builder(
            name = "Home",
            defaultWidth = 25.dp,
            defaultHeight = 24.dp,
            viewportWidth = 25f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFF2F2F3))) {
                moveTo(12.678f, 2.014f)
                curveTo(11.803f, 2.014f, 10.939f, 2.347f, 10.271f, 3.014f)
                lineTo(2.959f, 10.295f)
                curveTo(2.568f, 10.686f, 2.568f, 11.342f, 2.959f, 11.733f)
                lineTo(4.678f, 13.452f)
                verticalLineTo(17.014f)
                curveTo(4.678f, 19.223f, 6.469f, 21.014f, 8.678f, 21.014f)
                horizontalLineTo(16.678f)
                curveTo(18.887f, 21.014f, 20.678f, 19.223f, 20.678f, 17.014f)
                verticalLineTo(13.452f)
                lineTo(22.396f, 11.733f)
                curveTo(22.787f, 11.342f, 22.787f, 10.686f, 22.396f, 10.295f)
                curveTo(22.057f, 9.956f, 20.815f, 8.708f, 19.678f, 7.576f)
                verticalLineTo(5.014f)
                curveTo(19.678f, 4.462f, 19.23f, 4.014f, 18.678f, 4.014f)
                curveTo(18.125f, 4.014f, 17.678f, 4.462f, 17.678f, 5.014f)
                verticalLineTo(5.608f)
                curveTo(16.608f, 4.543f, 15.408f, 3.338f, 15.084f, 3.014f)
                curveTo(14.416f, 2.347f, 13.552f, 2.014f, 12.678f, 2.014f)
                close()
                moveTo(12.678f, 4.014f)
                curveTo(13.041f, 4.014f, 13.401f, 4.143f, 13.678f, 4.42f)
                curveTo(14.212f, 4.955f, 16.227f, 6.96f, 17.959f, 8.702f)
                curveTo(17.966f, 8.709f, 17.952f, 8.726f, 17.959f, 8.733f)
                curveTo(17.965f, 8.739f, 17.984f, 8.726f, 17.99f, 8.733f)
                curveTo(18.905f, 9.652f, 19.706f, 10.48f, 20.24f, 11.014f)
                lineTo(18.959f, 12.295f)
                curveTo(18.772f, 12.483f, 18.678f, 12.749f, 18.678f, 13.014f)
                verticalLineTo(17.014f)
                curveTo(18.678f, 18.119f, 17.782f, 19.014f, 16.678f, 19.014f)
                horizontalLineTo(8.678f)
                curveTo(7.573f, 19.014f, 6.678f, 18.119f, 6.678f, 17.014f)
                verticalLineTo(13.014f)
                curveTo(6.678f, 12.749f, 6.584f, 12.483f, 6.396f, 12.295f)
                lineTo(5.115f, 11.014f)
                lineTo(11.678f, 4.42f)
                curveTo(11.955f, 4.143f, 12.315f, 4.014f, 12.678f, 4.014f)
                close()
            }
        }.build()

        return _Home!!
    }

@Suppress("ObjectPropertyName")
private var _Home: ImageVector? = null