package com.y19th.feature.home.favourites.logic

import com.y19th.core.domain.models.courses.Course
import com.y19th.dextension.core.BaseState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf


internal sealed interface FavouritesState: BaseState {

	data object Loading: FavouritesState

	data object Empty: FavouritesState

	data class Success(val items: ImmutableList<Course> = persistentListOf()): FavouritesState
}