package com.y19th.core.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.y19th.core.local.entities.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface CourseDao {

    @Query("select id from course")
    fun courseIdsFlow(): Flow<List<Int>>

    @Query("select * from course")
    fun courseItemsFlow(): Flow<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(courseEntity: CourseEntity)

    @Query("select * from course")
    suspend fun takeAll(): List<CourseEntity>

    @Query("delete from course where :id == id")
    suspend fun deleteItem(id: Int)
}