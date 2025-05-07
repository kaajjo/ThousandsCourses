package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.Account: ImageVector
    get() {
        if (_Account != null) {
            return _Account!!
        }
        _Account = ImageVector.Builder(
            name = "Account",
            defaultWidth = 25.dp,
            defaultHeight = 24.dp,
            viewportWidth = 25f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFF2F2F3))) {
                moveTo(12.331f, 1.953f)
                curveTo(9.57f, 1.953f, 7.331f, 4.192f, 7.331f, 6.953f)
                curveTo(7.331f, 9.715f, 9.57f, 11.953f, 12.331f, 11.953f)
                curveTo(15.093f, 11.953f, 17.331f, 9.715f, 17.331f, 6.953f)
                curveTo(17.331f, 4.192f, 15.093f, 1.953f, 12.331f, 1.953f)
                close()
                moveTo(12.331f, 3.953f)
                curveTo(13.988f, 3.953f, 15.331f, 5.296f, 15.331f, 6.953f)
                curveTo(15.331f, 8.61f, 13.988f, 9.953f, 12.331f, 9.953f)
                curveTo(10.674f, 9.953f, 9.331f, 8.61f, 9.331f, 6.953f)
                curveTo(9.331f, 5.296f, 10.674f, 3.953f, 12.331f, 3.953f)
                close()
                moveTo(8.8f, 13.266f)
                curveTo(6.186f, 13.98f, 4.331f, 16.253f, 4.331f, 18.953f)
                verticalLineTo(20.953f)
                curveTo(4.331f, 21.506f, 4.779f, 21.953f, 5.331f, 21.953f)
                horizontalLineTo(19.331f)
                curveTo(19.884f, 21.953f, 20.331f, 21.506f, 20.331f, 20.953f)
                verticalLineTo(18.953f)
                curveTo(20.331f, 16.253f, 18.477f, 13.98f, 15.863f, 13.266f)
                curveTo(15.638f, 13.204f, 15.418f, 13.233f, 15.206f, 13.328f)
                curveTo(14.291f, 13.741f, 13.316f, 13.953f, 12.331f, 13.953f)
                curveTo(11.346f, 13.953f, 10.372f, 13.741f, 9.456f, 13.328f)
                curveTo(9.244f, 13.233f, 9.024f, 13.204f, 8.8f, 13.266f)
                close()
                moveTo(9.206f, 15.266f)
                curveTo(10.216f, 15.648f, 11.251f, 15.953f, 12.331f, 15.953f)
                curveTo(13.412f, 15.953f, 14.446f, 15.648f, 15.456f, 15.266f)
                curveTo(17.16f, 15.782f, 18.331f, 17.22f, 18.331f, 18.953f)
                verticalLineTo(19.953f)
                horizontalLineTo(6.331f)
                verticalLineTo(18.953f)
                curveTo(6.331f, 17.22f, 7.503f, 15.782f, 9.206f, 15.266f)
                close()
            }
        }.build()

        return _Account!!
    }

@Suppress("ObjectPropertyName")
private var _Account: ImageVector? = null