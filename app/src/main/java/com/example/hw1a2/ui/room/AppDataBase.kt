package com.example.hw1a2.ui.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw1a2.News

@Database(entities = [News::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun newsDao():NewsDao
}