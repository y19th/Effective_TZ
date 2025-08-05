package com.y19th.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.y19th.core.local.entities.TransitionEntity

@Dao
internal interface TransitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun replace(transitionEntity: TransitionEntity)

    @Query("select * from transition")
    suspend fun take(): TransitionEntity?
}