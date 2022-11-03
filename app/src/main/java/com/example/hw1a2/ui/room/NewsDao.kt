package com.example.hw1a2.ui.room

import androidx.room.*
import com.example.hw1a2.News


@Dao
interface NewsDao  {

    @Query("SELECT * FROM news order by createdAt DESC")
    open fun getAll(): MutableList<News?>?

    @Query("SELECT * FROM news order by title ASC")
    fun getAllSortedTitle(): List<News?>?

    @Insert
    fun insert(news: News?)

    @Update
    fun update(news: News?)

    @Delete
    fun delete(news: News?)
}