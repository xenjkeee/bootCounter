package com.example.booter1

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BootEntity::class], version = 1)
abstract class BootDatabase : RoomDatabase() {
    abstract fun bootDao(): BootDao
}