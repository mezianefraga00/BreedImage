package com.example.bathandbodyandbeyondinterview.retrofit

import com.example.bathandbodyandbeyondinterview.retrofit.ApiHelper


class Repo(private val apiHelper: ApiHelper) {
    suspend fun getPictures(s: String) = apiHelper.getPictures(s)
}