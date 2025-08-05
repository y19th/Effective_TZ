package com.y19th.core.local.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.y19th.core.util.di.DependencyCollector
import com.y19th.core.util.extension.context
import com.y19th.core.util.local.screenCoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers

private class AndroidDatabaseBuilder {
    fun create(path: String): MainDatabase {
        return Room.databaseBuilder<MainDatabase>(
            context = DependencyCollector.context(),
            name = path
        ).fallbackToDestructiveMigration(true)
            .setQueryCoroutineContext(screenCoroutineExceptionHandler("RoomAndroid") + Dispatchers.IO)
            .setDriver(BundledSQLiteDriver())
            .build()
    }

}

internal fun defaultDatabaseBuilder(): MainDatabase {
    return AndroidDatabaseBuilder().create("${DependencyCollector.context().filesDir}/androidDatabase.db")
}