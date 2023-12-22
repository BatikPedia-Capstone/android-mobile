package com.example.batikpedia.data.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Member(
    val name: String,
    val role: String,
    val photo: String
): Parcelable
