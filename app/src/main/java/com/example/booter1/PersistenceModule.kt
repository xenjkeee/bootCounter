package com.example.booter1

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PersistenceModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context = context.applicationContext,
        klass = BootDatabase::class.java,
        name = "boots_database"
    ).build()

    @Provides
    fun provideBootsDao(database: BootDatabase) = database.bootDao()
}