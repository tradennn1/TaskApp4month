package com.example.hw1a2

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity
data class News(
    @PrimaryKey (autoGenerate = true)
    val id:Int,
    val title:String,
    val createdAt:Long,
) :Serializable
