package com.y19th.feature.home.main.logic

import com.y19th.dextension.core.BaseEffects

internal sealed interface MainEffects: BaseEffects {

    data object OnSorted: MainEffects
}