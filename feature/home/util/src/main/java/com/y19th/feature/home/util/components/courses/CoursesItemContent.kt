package com.y19th.feature.home.util.components.courses

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composeunstyled.Icon
import com.y19th.core.domain.models.courses.Course
import com.y19th.core.ui.components.EffectiveText
import com.y19th.core.ui.components.HorizontalSpacer
import com.y19th.core.ui.components.VerticalSpacer
import com.y19th.core.ui.theme.darkGrey
import com.y19th.core.ui.theme.glass
import com.y19th.core.ui.theme.green
import com.y19th.core.ui.theme.scheme
import com.y19th.core.util.extension.defaultFormat
import com.y19th.feature.home.util.R

@Composable
fun CoursesItemContent(
    item: Course,
    modifier: Modifier = Modifier,
    onFavouriteIconClick: () -> Unit
) {
    val state = rememberUpdatedState(item)

    Column(
        modifier = modifier
            .background(
                color = scheme.darkGrey,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Box {
            Image(
                modifier = Modifier
                    .size(width = 328.dp, height = 114.dp),
                painter = painterResource(R.drawable.placeholder),
                contentDescription = null
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(all = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .background(
                            color = scheme.glass,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.icon_rating),
                        tint = scheme.green,
                        contentDescription = null
                    )

                    HorizontalSpacer(4.dp)

                    EffectiveText(
                        text = state.value.rate,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        letterSpacing = 0.4.sp
                    )
                }

                HorizontalSpacer(4.dp)

                EffectiveText(
                    modifier = Modifier
                        .background(
                            color = scheme.glass,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 4.dp),
                    text = state.value.publishDate.defaultFormat(),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 14.sp,
                    letterSpacing = 0.4.sp
                )
            }

            Icon(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(all = 8.dp)
                    .background(
                        color = scheme.glass,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .clickable(onClick = onFavouriteIconClick)
                    .padding(all = 6.dp),
                imageVector = ImageVector.vectorResource(R.drawable.icon_bookmark),
                //иконки на зеленый нет
                tint = if (state.value.hasLike) scheme.green else scheme.onSurface,
                contentDescription = null
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            EffectiveText(
                text = state.value.title,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                letterSpacing = 0.15.sp,
                color = scheme.onSurface
            )

            VerticalSpacer(12.dp)

            EffectiveText(
                text = state.value.text,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFFF2F2F3)
            )

            VerticalSpacer(10.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                EffectiveText(
                    text = "${state.value.price} ₽",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 18.sp,
                    letterSpacing = 0.15.sp,
                    color = scheme.onSurface
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EffectiveText(
                        text = stringResource(R.string.home_main_screen_courses_item_more),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.4.sp,
                        lineHeight = 15.sp,
                        color = scheme.green
                    )

                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.icon_arrow_more),
                        tint = scheme.green,
                        contentDescription = null
                    )
                }
            }
        }
    }
}