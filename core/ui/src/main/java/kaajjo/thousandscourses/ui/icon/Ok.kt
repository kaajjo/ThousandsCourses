package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Ok: ImageVector
    get() {
        if (_Test != null) {
            return _Test!!
        }
        _Test = ImageVector.Builder(
            name = "Ok",
            defaultWidth = 50.dp,
            defaultHeight = 40.dp,
            viewportWidth = 50f,
            viewportHeight = 40f
        ).apply {
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(27.757f, 25.879f)
                curveTo(29.144f, 25.567f, 30.482f, 25.026f, 31.714f, 24.262f)
                curveTo(32.647f, 23.682f, 32.928f, 22.466f, 32.34f, 21.546f)
                curveTo(31.753f, 20.624f, 30.521f, 20.347f, 29.587f, 20.927f)
                curveTo(26.796f, 22.658f, 23.202f, 22.658f, 20.413f, 20.927f)
                curveTo(19.478f, 20.347f, 18.246f, 20.624f, 17.66f, 21.546f)
                curveTo(17.073f, 22.467f, 17.353f, 23.682f, 18.285f, 24.262f)
                curveTo(19.517f, 25.025f, 20.855f, 25.567f, 22.242f, 25.879f)
                lineTo(18.433f, 29.638f)
                curveTo(17.654f, 30.407f, 17.654f, 31.654f, 18.433f, 32.423f)
                curveTo(18.824f, 32.807f, 19.334f, 33f, 19.844f, 33f)
                curveTo(20.356f, 33f, 20.867f, 32.807f, 21.257f, 32.423f)
                lineTo(24.999f, 28.729f)
                lineTo(28.745f, 32.423f)
                curveTo(29.524f, 33.192f, 30.787f, 33.192f, 31.567f, 32.423f)
                curveTo(32.347f, 31.654f, 32.347f, 30.406f, 31.567f, 29.638f)
                lineTo(27.757f, 25.879f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFFFFFF))) {
                moveTo(31.776f, 13.717f)
                curveTo(31.776f, 17.42f, 28.716f, 20.432f, 24.952f, 20.432f)
                curveTo(21.188f, 20.432f, 18.127f, 17.42f, 18.127f, 13.717f)
                curveTo(18.127f, 10.013f, 21.188f, 7f, 24.952f, 7f)
                curveTo(28.716f, 7f, 31.776f, 10.013f, 31.776f, 13.717f)
                close()
                moveTo(27.777f, 13.717f)
                curveTo(27.777f, 12.183f, 26.51f, 10.936f, 24.952f, 10.936f)
                curveTo(23.395f, 10.936f, 22.126f, 12.183f, 22.126f, 13.717f)
                curveTo(22.126f, 15.249f, 23.395f, 16.497f, 24.952f, 16.497f)
                curveTo(26.51f, 16.497f, 27.777f, 15.249f, 27.777f, 13.717f)
                close()
            }
        }.build()

        return _Test!!
    }

@Suppress("ObjectPropertyName")
private var _Test: ImageVector? = null
