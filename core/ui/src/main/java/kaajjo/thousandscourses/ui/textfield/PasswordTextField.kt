package kaajjo.thousandscourses.ui.textfield

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    isError: Boolean = false,
    onValidationChange: (Boolean) -> Unit = {},
) {
    val isValidPassword = value.length >= 8

    RoundedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        isError = isError || (value.isNotEmpty() && !isValidPassword),
        leadingIcon = leadingIcon,
        placeholder = { Text("Введите пароль") },
        enabled = enabled,
        singleLine = true,
        visualTransformation = PasswordVisualTransformation()
    )

    LaunchedEffect(isValidPassword) {
        onValidationChange(isValidPassword)
    }
}