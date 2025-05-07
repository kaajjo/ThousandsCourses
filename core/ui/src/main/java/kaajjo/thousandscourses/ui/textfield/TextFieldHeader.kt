package kaajjo.thousandscourses.ui.textfield

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun TextFieldHeader(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
) {
    Text(
        text = text,
        style = style,
        modifier = modifier
    )
}
