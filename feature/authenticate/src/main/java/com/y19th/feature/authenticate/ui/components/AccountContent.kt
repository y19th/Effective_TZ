package com.y19th.feature.authenticate.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.VerticalSpacer
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme
import com.y19th.feature.authenticate.R

@Composable
internal fun AccountContent(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        EffectiveText(
            text = stringResource(R.string.authenticate_screen_account_question),
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.4.sp
        )

        EffectiveText(
            text = stringResource(R.string.authenticate_screen_account_register),
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            lineHeight = 15.sp,
            letterSpacing = 0.4.sp,
            color = scheme.green
        )
    }

    VerticalSpacer(8.dp)

    EffectiveText(
        text = stringResource(R.string.authenticate_screen_account_forgot_password),
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp,
        lineHeight = 15.sp,
        letterSpacing = 0.4.sp,
        color = scheme.green
    )
}