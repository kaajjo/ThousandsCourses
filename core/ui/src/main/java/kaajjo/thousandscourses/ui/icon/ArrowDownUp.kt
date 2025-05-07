package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.ArrowDownUp: ImageVector
    get() {
        if (_ArrowDownUp != null) {
            return _ArrowDownUp!!
        }
        _ArrowDownUp = ImageVector.Builder(
            name = "ArrowDownUp",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF12B956))) {
                moveTo(16.008f, 2.015f)
                curveTo(15.752f, 2.015f, 15.484f, 2.1f, 15.288f, 2.295f)
                lineTo(11.601f, 6.014f)
                lineTo(13.008f, 7.421f)
                lineTo(15.008f, 5.453f)
                verticalLineTo(20.015f)
                curveTo(15.008f, 20.567f, 15.454f, 21.014f, 16.008f, 21.014f)
                curveTo(16.56f, 21.014f, 17.007f, 20.567f, 17.007f, 20.015f)
                verticalLineTo(5.453f)
                lineTo(19.008f, 7.421f)
                lineTo(20.414f, 6.014f)
                lineTo(16.727f, 2.295f)
                curveTo(16.532f, 2.1f, 16.263f, 2.015f, 16.008f, 2.015f)
                close()
                moveTo(8.007f, 3.014f)
                curveTo(7.455f, 3.014f, 7.008f, 3.462f, 7.008f, 4.014f)
                verticalLineTo(18.576f)
                lineTo(5.007f, 16.608f)
                lineTo(3.602f, 18.014f)
                lineTo(7.289f, 21.734f)
                curveTo(7.679f, 22.124f, 8.336f, 22.124f, 8.726f, 21.734f)
                lineTo(12.414f, 18.014f)
                lineTo(11.007f, 16.608f)
                lineTo(9.008f, 18.576f)
                verticalLineTo(4.014f)
                curveTo(9.008f, 3.462f, 8.56f, 3.014f, 8.007f, 3.014f)
                close()
            }
        }.build()

        return _ArrowDownUp!!
    }

@Suppress("ObjectPropertyName")
private var _ArrowDownUp: ImageVector? = null