package com.y19th.feature.authenticate.ui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.components.EffectiveColumn
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.VerticalSpacer
import com.y19th.core.ui.components.buttons.EffectiveButton
import com.y19th.core.ui.components.fields.EffectiveTextField
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.authenticate.R
import com.y19th.feature.authenticate.logic.AuthenticateEvents
import com.y19th.feature.authenticate.ui.components.AccountContent
import com.y19th.feature.authenticate.ui.components.SocialContent

@Composable
internal fun AuthenticateContent(
    component: AuthenticateComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    EffectiveColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier = Modifier.weight(0.2f)
        )

        EffectiveText(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.authenticate_screen_header),
            fontWeight = FontWeight.Normal,
            fontSize = 28.sp,
            lineHeight = 36.sp
        )

        VerticalSpacer(28.dp)

        EffectiveTextField(
            value = state.value.email.value,
            error = state.value.email.isError,
            placeHolder = stringResource(R.string.authenticate_screen_email_field_placeholder),
            errorText = stringResource(R.string.authenticate_screen_email_field_error),
            title = stringResource(R.string.authenticate_screen_email_field_header),
            onValueChange = { handleEvents(AuthenticateEvents.OnEmailChanged(it)) }
        )

        VerticalSpacer(16.dp)

        EffectiveTextField(
            value = state.value.password.value,
            error = state.value.password.isError,
            placeHolder = stringResource(R.string.authenticate_screen_password_field_placeholder),
            errorText = stringResource(R.string.authenticate_screen_password_field_error),
            title = stringResource(R.string.authenticate_screen_password_field_header),
            onValueChange = { handleEvents(AuthenticateEvents.OnPasswordChanged(it)) }
        )

        VerticalSpacer(24.dp)

        EffectiveButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(R.string.authenticate_screen_button_enter),
            backgroundColor = scheme.green,
            enabled = state.value.valid,
            onClick = { handleEvents(AuthenticateEvents.OnValidateAuthenticate) }
        )

        VerticalSpacer(16.dp)

        AccountContent()

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 32.dp),
            color = Color(0xFF4D555E)
        )

        SocialContent(
            onEvent = handleEvents
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )
    }
}