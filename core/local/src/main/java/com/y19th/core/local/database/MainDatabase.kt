package com.y19th.core.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.y19th.core.local.dao.TransitionDao
import com.y19th.core.local.entities.TransitionEntity

@Database(
    entities = [
        TransitionEntity::class,
               ],
    version = 1,
    exportSchema = true
)
internal abstract class MainDatabase: RoomDatabase() {

    abstract fun transitionDao(): TransitionDao
}