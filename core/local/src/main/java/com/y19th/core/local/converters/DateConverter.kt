package com.y19th.core.local.converters

import androidx.room.TypeConverter
import com.y19th.core.util.extension.decode
import com.y19th.core.util.extension.encode
import kotlinx.datetime.LocalDate

internal class DateConverter {

    @TypeConverter
    fun fromLocalDate(date: LocalDate): String = date.encode()

    @TypeConverter
    fun toLocalDate(value: String): LocalDate = value.decode()
}
