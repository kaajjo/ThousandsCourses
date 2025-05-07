package kaajjo.thousandscourses.ui.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import kaajjo.thousandscourses.ui.ThousandsCoursesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoundedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isError: Boolean = false,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
) {
    val colors = OutlinedTextFieldDefaults.colors(
        unfocusedContainerColor = Color(0xFF32333A),
        focusedContainerColor = Color(0xFF484950),
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        unfocusedPlaceholderColor = Color(0xFF9E9E9E),
        errorBorderColor = Color.Transparent,
        errorContainerColor = Color(0xFF484950)
    )
    val interactionSource = remember { MutableInteractionSource() }
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        enabled = enabled,
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant),
        textStyle = LocalTextStyle.current.copy(color = LocalContentColor.current),
    ) { innerTextField ->
        TextFieldDefaults.DecorationBox(
            value = value,
            visualTransformation = visualTransformation,
            innerTextField = innerTextField,
            enabled = enabled,
            interactionSource = interactionSource,
            singleLine = singleLine,
            placeholder = placeholder,
            colors = colors,
            contentPadding = contentPadding,
            isError = isError,
            label = label,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            prefix = prefix,
            suffix = suffix,
            supportingText = supportingText,
            shape = MaterialTheme.shapes.extraLarge
        )
    }
}

@Composable
@androidx.compose.ui.tooling.preview.Preview
fun RoundedTextFieldPreview() {
    ThousandsCoursesTheme {
        Column(modifier = Modifier.padding(12.dp)) {
            RoundedTextField(
                value = "Preview text",
                onValueChange = {},
                placeholder = { Text("Placeholder text") }
            )
        }
    }
}