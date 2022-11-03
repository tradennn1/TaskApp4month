package com.example.hw1a2

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import com.example.hw1a2.ui.room.AppDataBase
import com.google.firebase.auth.FirebaseAuth

class App:Application() {


    companion object{
        private lateinit var instace:App
        lateinit var dataBase:AppDataBase



        fun getInstance(): App {
            return instace
        }

    }

    override fun onCreate() {
        super.onCreate()
        instace = this
        dataBase = Room.databaseBuilder(this,AppDataBase::class.java,"dataBase").allowMainThreadQueries()
            .build()
    }

    fun getDatabase(): AppDataBase {
        return dataBase

    }
}