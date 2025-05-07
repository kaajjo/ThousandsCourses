package kaajjo.thousandscourses.ui.textfield

import androidx.compose.animation.AnimatedContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    onValidationChange: (Boolean) -> Unit = {},
) {
    val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")

    val isValidEmail = !value.isEmpty() && emailRegex.matches(value)

    val filterInput = { text: String ->
        text.filter { it.code in 32..126 }
    }

    RoundedTextField(
        value = value,
        onValueChange = { newValue -> onValueChange(filterInput(newValue)) },
        modifier = modifier,
        leadingIcon = leadingIcon,
        trailingIcon = {
            if (value.isNotEmpty()) {
                AnimatedContent(isValidEmail) { state ->
                    if (state) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.Error,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.error
                        )
                    }
                }
            }
        },
        placeholder = { Text("example@domain.com") },
        enabled = enabled,
        singleLine = true
    )

    LaunchedEffect(isValidEmail) {
        onValidationChange(isValidEmail)
    }
}