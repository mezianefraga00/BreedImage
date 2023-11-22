package com.example.bathandbodyandbeyondinterview.breed_search_result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bathandbodyandbeyondinterview.retrofit.ApiHelper
import com.example.bathandbodyandbeyondinterview.retrofit.Repo


class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return DogImagesViewModel(Repo(apiHelper)) as T
}
}
