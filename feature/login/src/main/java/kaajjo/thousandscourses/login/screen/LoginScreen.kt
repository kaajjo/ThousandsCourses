package kaajjo.thousandscourses.login.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kaajjo.thousandscourses.login.R
import kaajjo.thousandscourses.ui.button.AccentButton
import kaajjo.thousandscourses.ui.button.OkSocialButton
import kaajjo.thousandscourses.ui.button.VkSocialButton
import kaajjo.thousandscourses.ui.textfield.EmailTextField
import kaajjo.thousandscourses.ui.textfield.PasswordTextField
import kaajjo.thousandscourses.ui.textfield.TextFieldHeader
import ru.smarttech.common.Constants

interface LoginNavigator {
    fun navigateToMain()
}

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun LoginScreen(
    navigator: LoginNavigator
) {
    val uriHandler = LocalUriHandler.current
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(stringResource(R.string.label_ogin))
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            var email by remember { mutableStateOf("") }
            var isValidEmail by rememberSaveable { mutableStateOf(false) }
            var password by remember { mutableStateOf("") }
            var isValidPassword by rememberSaveable { mutableStateOf(false) }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                TextFieldHeader(
                    text = stringResource(R.string.label_email),
                    modifier = Modifier.padding(top = 12.dp)
                )
                EmailTextField(
                    value = email,
                    onValueChange = {
                        email = it.filter { char ->
                            (char in 'A'..'Z' || char in 'a'..'z' || char.isDigit() || char == '@' || char == '.')
                        }
                    },
                    onValidationChange = { isValidEmail = it },
                    modifier = Modifier.fillMaxWidth()
                )
                TextFieldHeader(
                    text = stringResource(R.string.label_password)
                )
                PasswordTextField(
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    onValidationChange = { isValidPassword = it },
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            AccentButton(
                modifier = Modifier.fillMaxWidth(),
                enabled = isValidEmail && isValidPassword,
                onClick = {
                    navigator.navigateToMain()
                }
            ) {
                Text(stringResource(R.string.action_login))
            }
            Row(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(onClick = {})
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.titleSmall) {
                    Text(stringResource(R.string.login_no_account))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(R.string.login_register),
                        color = Color(0xFF12B956)
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(R.string.login_forgot_pass),
                color = Color(0xFF12B956),
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .clickable(onClick = {})
                    .padding(horizontal = 8.dp, vertical = 4.dp)
                    .align(Alignment.CenterHorizontally)
            )

            HorizontalDivider(modifier = Modifier.padding(vertical = 32.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                VkSocialButton(onClick = {
                    uriHandler.openUri(Constants.URL_VK)
                }, modifier = Modifier.weight(1f))

                Spacer(modifier = Modifier.width(16.dp))

                OkSocialButton(onClick = {
                    uriHandler.openUri(Constants.URL_OK)
                }, modifier = Modifier.weight(1f))
            }
        }
    }
}