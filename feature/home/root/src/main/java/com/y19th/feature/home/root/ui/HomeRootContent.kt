package com.y19th.feature.home.root.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.y19th.core.navigation.navigators.home.HomeConfiguration
import com.y19th.dextension.compose.DefaultChildren
import com.y19th.dextension.compose.ProvideContent
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.home.root.R
import com.y19th.feature.home.root.logic.HomeRootEvents
import com.y19th.feature.home.root.ui.components.HomeNavigationItem

@Composable
internal fun RootContent(
    component: HomeRootComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .drawBehind {
                        drawLine(
                            color = Color(0xFF4D555E),
                            strokeWidth = 1.5.dp.toPx(),
                            start = Offset(0f, 0f),
                            end = Offset(size.width, 0f)
                        )
                    },
                containerColor = Color(0xFF24252A)
            ) {
                HomeNavigationItem(
                    selected = state.value.currentDestination == HomeConfiguration.Main,
                    icon = ImageVector.vectorResource(R.drawable.icon_main),
                    labelText = stringResource(R.string.home_root_screen_navigation_main),
                    onClick = { handleEvents(HomeRootEvents.OnMainScreen) }
                )

                HomeNavigationItem(
                    selected = state.value.currentDestination == HomeConfiguration.Favourites,
                    icon = ImageVector.vectorResource(R.drawable.icon_favourites),
                    labelText = stringResource(R.string.home_root_screen_navigation_favourites),
                    onClick = { handleEvents(HomeRootEvents.OnFavouritesScreen) }
                )

                HomeNavigationItem(
                    selected = state.value.currentDestination == HomeConfiguration.Account,
                    icon = ImageVector.vectorResource(R.drawable.icon_account),
                    labelText = stringResource(R.string.home_root_screen_navigation_account),
                    onClick = { handleEvents(HomeRootEvents.OnAccountScreen) }
                )
            }
        }
    ) {
        DefaultChildren(
            modifier = Modifier.padding(it),
            stack = component.stack
        ) { instance ->
            ProvideContent(
                when (instance) {
                    is HomeRootComponent.Child.Main -> instance.screen
                    is HomeRootComponent.Child.Favourites -> instance.screen
                    is HomeRootComponent.Child.Account -> instance.screen
                }
            )
        }

    }
}