package com.example.booter1

import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BootsRepository @Inject constructor(
    private val bootsDao: BootDao
) {

    fun getAll() = bootsDao.getAll().map { list -> list.map { it.bootedAt } }

    suspend fun addBoot(timestamp: Long) = bootsDao.insert(BootEntity(0, timestamp))
}