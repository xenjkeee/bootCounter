package com.example.booter1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boots")
data class BootEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "booted_at") val bootedAt: Long
)