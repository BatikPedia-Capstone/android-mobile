package com.example.batikpedia.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface BatikDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(batik: Batik)

    @Update
    fun update(batik: Batik)

    @Delete
    fun delete(batik: Batik)

    @Query("SELECT*from batik ORDER BY id ASC")
    fun getAllBatik(): LiveData<List<Batik>>
}