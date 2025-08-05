package com.y19th.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.y19th.core.local.converters.DateConverter
import com.y19th.core.local.dao.CourseDao
import com.y19th.core.local.dao.TransitionDao
import com.y19th.core.local.entities.CourseEntity
import com.y19th.core.local.entities.TransitionEntity

@Database(
    entities = [
        TransitionEntity::class,
        CourseEntity::class
    ],
    version = 1,
    exportSchema = true
)
@TypeConverters(
    DateConverter::class
)
internal abstract class MainDatabase : RoomDatabase() {

    abstract fun transitionDao(): TransitionDao

    abstract fun courseDao(): CourseDao
}