package com.example.batikpedia.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "batik")
data class  Batik(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id" )
    var id: Int = 0,

    @ColumnInfo(name = "nama_batik")
    var namaBatik: String? = null,

    @ColumnInfo(name = "confidence")
    var confidence:String?=null,
)
