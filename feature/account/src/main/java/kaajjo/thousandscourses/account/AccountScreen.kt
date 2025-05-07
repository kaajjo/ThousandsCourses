package kaajjo.thousandscourses.account

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import kaajjo.thousandscourses.account.components.TextRow
import kaajjo.thousandscourses.ui.card.DefaultCard
import kaajjo.thousandscourses.ui.icon.IconRight


@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun AccountScreen(

) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.profile_title)) }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(top = innerPadding.calculateTopPadding()),
            contentPadding = PaddingValues(12.dp)
        ) {
            item {
                DefaultCard {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp)
                    ) {
                        TextRow(
                            text = stringResource(R.string.chat_support),
                            onClick = { /* TODO */ },
                            action = {
                                Icon(
                                    imageVector = Icons.IconRight,
                                    contentDescription = null
                                )
                            }
                        )
                        HorizontalDivider()
                        TextRow(
                            text = stringResource(R.string.label_settings),
                            onClick = { /* TODO */ },
                            action = {
                                Icon(
                                    imageVector = Icons.IconRight,
                                    contentDescription = null
                                )
                            }
                        )
                        HorizontalDivider()
                        TextRow(
                            text = stringResource(R.string.label_logout),
                            onClick = { /* TODO */ },
                            action = {
                                Icon(
                                    imageVector = Icons.IconRight,
                                    contentDescription = null
                                )
                            }
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Text(
                    text = stringResource(R.string.profile_your_courses),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        }
    }
}