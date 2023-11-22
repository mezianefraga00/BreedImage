package com.example.bathandbodyandbeyondinterview.dataClasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BreedName(
    val name : String = ""
): Parcelable