package com.y19th.feature.home.logic

import com.y19th.dextension.core.BaseEvents
                    
internal sealed interface HomeEvents : BaseEvents {
    
    data object OnNavigateBack: HomeEvents
}