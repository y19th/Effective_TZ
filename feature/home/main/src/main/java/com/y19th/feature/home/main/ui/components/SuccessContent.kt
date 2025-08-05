package com.y19th.feature.home.main.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.y19th.core.domain.models.courses.Course
import com.y19th.feature.home.main.logic.MainEvents
import com.y19th.feature.home.util.components.courses.CoursesItemContent
import kotlinx.collections.immutable.ImmutableList

@Composable
internal fun SuccessContent(
    courses: ImmutableList<Course>,
    lazyState: LazyListState,
    modifier: Modifier = Modifier,
    onEvent: (MainEvents) -> Unit
) {
    val innerState = rememberUpdatedState(courses)

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 24.dp),
        state = lazyState
    ) {
        items(
            items = innerState.value,
            key = { it.id },
            contentType = { it }
        ) { item ->
            CoursesItemContent(
                modifier = Modifier
                    .animateItem(),
                item = item,
                onFavouriteIconClick = { onEvent(MainEvents.OnFavouriteIconClick(item)) }
            )
        }
    }
}