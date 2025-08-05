package com.y19th.core.util.extension

import com.y19th.core.resources.models.russianMonthNames
import kotlinx.datetime.LocalDate
import kotlinx.datetime.format
import kotlinx.datetime.format.char

private val dateFormat = LocalDate.Format {
    dayOfMonth(); char(' '); monthName(russianMonthNames); char(' '); year()
}


fun LocalDate.defaultFormat(): String {
    return format(dateFormat)
}