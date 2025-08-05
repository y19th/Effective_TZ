package com.y19th.feature.home.main.logic

import com.y19th.core.domain.models.courses.Course
import com.y19th.dextension.core.BaseEvents

internal sealed interface MainEvents : BaseEvents {

    data object OnDateFilterClick : MainEvents

    data class OnFavouriteIconClick(val item: Course) : MainEvents
}