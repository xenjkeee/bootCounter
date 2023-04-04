package com.example.booter1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BootDao {
    @Query("SELECT * FROM boots")
    fun getAll(): Flow<List<BootEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(boot: BootEntity)
}