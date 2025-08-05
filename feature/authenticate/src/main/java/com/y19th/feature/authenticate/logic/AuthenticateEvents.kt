package com.y19th.feature.authenticate.logic

import com.y19th.dextension.core.BaseEvents
                    
internal sealed interface AuthenticateEvents : BaseEvents {

    data class OnEmailChanged(val newValue: String): AuthenticateEvents

    data class OnPasswordChanged(val newValue: String): AuthenticateEvents

    data object OnValidateAuthenticate: AuthenticateEvents

    data object OnVkClicked: AuthenticateEvents

    data object OnOkClicked: AuthenticateEvents
}