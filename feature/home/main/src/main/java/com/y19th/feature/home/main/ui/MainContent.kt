package com.y19th.feature.home.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeunstyled.Icon
import com.y19th.core.ui.components.EffectiveColumn
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.HorizontalSpacer
import com.y19th.core.ui.components.VerticalSpacer
import com.y19th.core.ui.components.fields.EffectiveTextField
import com.y19th.core.ui.theme.darkGrey
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme
import com.y19th.dextension.compose.collectAsImmediateState
import com.y19th.dextension.compose.rememberHandleEvents
import com.y19th.feature.home.main.R
import com.y19th.feature.home.main.logic.MainState
import com.y19th.feature.home.main.ui.components.ErrorContent
import com.y19th.feature.home.main.ui.components.LoadingContent
import com.y19th.feature.home.main.ui.components.SuccessContent

@Composable
internal fun MainContent(
    component: MainComponent
) {
    val state = component.state.collectAsImmediateState()
    val handleEvents = component.rememberHandleEvents()

    EffectiveColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Row {
            EffectiveTextField(
                modifier = Modifier
                    .weight(1f),
                value = "",
                onValueChange = {},
                placeHolder = stringResource(R.string.home_main_screen_filter_placeholder),
                leadingIcon = ImageVector.vectorResource(R.drawable.icon_search),
                contentPadding = PaddingValues(vertical = 19.dp, horizontal = 16.dp),
                backgroundColor = scheme.darkGrey,
                shape = RoundedCornerShape(28.dp)
            )

            HorizontalSpacer(8.dp)

            Icon(
                modifier = Modifier
                    .background(
                        color = scheme.darkGrey,
                        shape = CircleShape
                    )
                    .padding(all = 16.dp),
                imageVector = ImageVector.vectorResource(R.drawable.icon_filter),
                tint = scheme.onSurface,
                contentDescription = null
            )
        }

        VerticalSpacer(16.dp)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            EffectiveText(
                text = stringResource(R.string.home_main_screen_filter_date),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                letterSpacing = 0.1.sp,
                color = scheme.green
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.icon_date_filter),
                tint = scheme.green,
                contentDescription = null
            )
        }

        VerticalSpacer(16.dp)

        when (val innerState = state.value) {
            is MainState.Error -> {
                ErrorContent(innerState)
            }

            MainState.Loading -> {
                LoadingContent()
            }

            is MainState.Success -> {
                SuccessContent(innerState)
            }
        }
    }
}