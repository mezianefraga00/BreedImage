package com.example.bathandbodyandbeyondinterview.retrofit

import com.example.bathandbodyandbeyondinterview.dataClasses.BreedImage
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
     @GET("/api/breed/{breed}/images")
     suspend fun getPictures(@Path("breed") breed: String) : BreedImage?
 }