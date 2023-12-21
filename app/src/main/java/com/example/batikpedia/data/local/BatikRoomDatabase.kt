package com.example.batikpedia.data.local

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class BatikRoomDatabase : RoomDatabase() {
    abstract fun batikDao(): BatikDao

    companion object {
        private var INSTANCE: BatikRoomDatabase? = null

        fun getDatabase(context: Context): BatikRoomDatabase {
            if (INSTANCE == null) {
                synchronized(BatikRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        BatikRoomDatabase::class.java, "batik_database"
                    )
                        .build()
                }
            }
            return INSTANCE as BatikRoomDatabase
        }
    }
}