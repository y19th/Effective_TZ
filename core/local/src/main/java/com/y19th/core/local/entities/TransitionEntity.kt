package com.y19th.core.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val defaultTransitionId = 52

@Entity(tableName = "transition")
internal data class TransitionEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = defaultTransitionId,
    val stage: Int
)