package com.y19th.feature.home.favourites.logic

import com.y19th.core.domain.models.courses.Course
import com.y19th.dextension.core.BaseEvents
                    
internal sealed interface FavouritesEvents : BaseEvents {
    
    data class OnToggleFavourite(val item: Course): FavouritesEvents
}