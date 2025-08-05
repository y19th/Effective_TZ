package com.y19th.feature.home.account.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.y19th.core.ui.components.EffectiveColumn
import com.y19th.core.ui.components.buttons.EffectiveButton
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.home.account.logic.AccountEvents

@Composable
internal fun AccountContent(
    component: AccountComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    EffectiveColumn {
        EffectiveButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Вернуться к авторизации",
            onClick = { handleEvents(AccountEvents.OnNavigateBack) },
            backgroundColor = scheme.green
        )
    }
}