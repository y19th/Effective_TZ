package com.y19th.feature.home.account.logic

import com.y19th.dextension.core.BaseEvents
                    
internal sealed interface AccountEvents : BaseEvents {
    
    data object OnNavigateBack: AccountEvents
}