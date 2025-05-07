package kaajjo.thousandscourses.ui.bottombar

import android.R.attr.label
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

@Composable
fun RowScope.ThemedNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null
) {
    CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.primary) {
        NavigationBarItem(
            selected = selected,
            onClick = onClick,
            icon = icon,
            modifier = modifier,
            enabled = enabled,
            label = label,
            alwaysShowLabel = alwaysShowLabel,
            colors = NavigationBarItemDefaults.colors().copy(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedIndicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.05f),
            ),
            interactionSource = interactionSource,
        )
    }
}