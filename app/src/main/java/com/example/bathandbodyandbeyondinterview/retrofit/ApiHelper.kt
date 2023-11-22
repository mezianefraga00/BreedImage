package com.example.bathandbodyandbeyondinterview.retrofit

class ApiHelper(private val apiService: ApiService) {

    suspend fun getPictures(breed: String) = apiService.getPictures(breed)
}