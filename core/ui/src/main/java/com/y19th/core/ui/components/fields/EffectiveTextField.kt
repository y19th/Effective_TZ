package com.y19th.core.ui.components.fields

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.y19th.core.ui.R
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.VerticalSpacer
import com.y19th.core.ui.components.animated.AnimatedColumn
import com.y19th.core.ui.theme.scheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EffectiveTextField(
    value: String,
    modifier: Modifier = Modifier,
    title: String = "",
    enabled: Boolean = true,
    error: Boolean = false,
    errorText: String = stringResource(R.string.default_field_error),
    supportText: String = "",
    singleLine: Boolean = true,
    minLines: Int = 1,
    maxLines: Int = Int.MAX_VALUE,
    placeHolder: String = "",
    readOnly: Boolean = false,
    leadingIcon: ImageVector? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 11.dp),
    shape: RoundedCornerShape = RoundedCornerShape(30.dp),
    backgroundColor: Color = scheme.surface,
    onValueChange: (String) -> Unit
) {
    val state = rememberUpdatedState(value)
    val decoratedSupportText = decoratedSupportingText(supportText)
    val decoratedLeadingIcon = decoratedLeadingIcon(leadingIcon)
    val decoratedPlaceholderText = decoratedPlaceholderText(placeHolder)

    Column(
        modifier = modifier
    ) {
        if (title.isNotEmpty()) {
            EffectiveText(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.15.sp,
                text = title
            )

            VerticalSpacer(height = 6.dp)
        }

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = state.value,
            onValueChange = onValueChange,
            singleLine = singleLine,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            minLines = minLines,
            maxLines = maxLines,
            visualTransformation = VisualTransformation.None,
            readOnly = readOnly,
            cursorBrush = SolidColor(scheme.onSurface),
            textStyle = MaterialTheme.typography.bodySmall.copy(
                color = scheme.onSurface
            ),
            decorationBox = { inner ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = value,
                    innerTextField = inner,
                    enabled = enabled,
                    singleLine = singleLine,
                    interactionSource = remember { MutableInteractionSource() },
                    visualTransformation = VisualTransformation.None,
                    leadingIcon = decoratedLeadingIcon,
                    placeholder = decoratedPlaceholderText,
                    supportingText = decoratedSupportText,
                    contentPadding = contentPadding,
                    container = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    color = backgroundColor,
                                    shape = shape
                                )
                        )
                    },
                    trailingIcon = {
                        if (value.isNotEmpty()) {
                            Icon(
                                modifier = Modifier
                                    .clickable { onValueChange("") }
                                    .clip(CircleShape),
                                imageVector = Icons.Default.Clear,
                                contentDescription = "clear"
                            )
                        }
                    }
                )
            }
        )

        AnimatedColumn(error) {
            VerticalSpacer(height = 4.dp)

            EffectiveText(
                modifier = Modifier
                    .padding(horizontal = 4.dp),
                text = errorText,
                color = scheme.error,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
            )
        }
    }

}