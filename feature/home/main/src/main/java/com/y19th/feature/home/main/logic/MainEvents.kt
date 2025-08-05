package com.y19th.feature.home.main.logic

import com.y19th.dextension.core.BaseEvents
                    
internal sealed interface MainEvents : BaseEvents {
    
    data object OnNavigateBack: MainEvents
}