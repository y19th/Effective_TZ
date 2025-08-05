package com.y19th.feature.home.favourites.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.components.CenteredBox
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.Loader
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.home.favourites.R
import com.y19th.feature.home.favourites.logic.FavouritesEvents
import com.y19th.feature.home.favourites.logic.FavouritesState
import com.y19th.feature.home.util.components.courses.CoursesItemContent

@Composable
internal fun FavouritesContent(
    component: FavouritesComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 16.dp)
    ) {
        EffectiveText(
            modifier = Modifier
                .padding(vertical = 16.dp),
            text = stringResource(R.string.home_favourites_screen_header),
            fontWeight = FontWeight.Normal,
            fontSize = 22.sp,
            letterSpacing = 0.sp,
            lineHeight = 28.sp
        )

        when (val inner = state.value) {
            FavouritesState.Empty ->
                CenteredBox(modifier = Modifier.fillMaxSize()) {
                    EffectiveText(
                        text = stringResource(R.string.home_favourites_screen_empty_list),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

            FavouritesState.Loading ->
                Loader()

            is FavouritesState.Success ->
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    contentPadding = PaddingValues(bottom = 24.dp)
                ) {
                    items(
                        items = inner.items,
                        key = { it.id },
                        contentType = { it }
                    ) { item ->
                        CoursesItemContent(
                            modifier = Modifier
                                .animateItem(),
                            item = item,
                            onFavouriteIconClick = {
                                handleEvents(
                                    FavouritesEvents.OnToggleFavourite(
                                        item
                                    )
                                )
                            }
                        )
                    }
                }

        }
    }
}