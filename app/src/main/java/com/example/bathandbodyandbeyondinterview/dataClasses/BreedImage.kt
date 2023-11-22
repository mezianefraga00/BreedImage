package com.example.bathandbodyandbeyondinterview.dataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreedImage(
    val message: List<String>? = listOf(),
    val status: String
):Parcelable