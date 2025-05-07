package kaajjo.thousandscourses.ui.icon

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Icons.IconRight: ImageVector
    get() {
        if (_IconRight != null) {
            return _IconRight!!
        }
        _IconRight = ImageVector.Builder(
            name = "IconRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFF2F2F3))) {
                moveTo(16.164f, 12.145f)
                curveTo(16.164f, 11.864f, 16.062f, 11.632f, 15.843f, 11.413f)
                lineTo(10.574f, 6.26f)
                curveTo(10.396f, 6.082f, 10.184f, 6f, 9.931f, 6f)
                curveTo(9.417f, 6f, 9f, 6.404f, 9f, 6.917f)
                curveTo(9f, 7.17f, 9.109f, 7.403f, 9.294f, 7.588f)
                lineTo(13.975f, 12.138f)
                lineTo(9.294f, 16.702f)
                curveTo(9.109f, 16.887f, 9f, 17.113f, 9f, 17.373f)
                curveTo(9f, 17.886f, 9.417f, 18.296f, 9.931f, 18.296f)
                curveTo(10.184f, 18.296f, 10.396f, 18.207f, 10.574f, 18.029f)
                lineTo(15.843f, 12.877f)
                curveTo(16.069f, 12.658f, 16.164f, 12.425f, 16.164f, 12.145f)
                close()
            }
        }.build()

        return _IconRight!!
    }

@Suppress("ObjectPropertyName")
private var _IconRight: ImageVector? = null