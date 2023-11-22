package com.example.bathandbodyandbeyondinterview.breed_search_result

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bathandbodyandbeyondinterview.retrofit.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DogImagesViewModel(
    private val repo: Repo
) : ViewModel() {
    val listImageUrls = MutableLiveData<List<String>>()
    val error = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun displayBreedImage(k: String) {
        viewModelScope.launch(Dispatchers.IO) {
        try {

            val result = repo.getPictures(k)
                if(result?.status == "success")
                listImageUrls.postValue(result.message!!)

        }catch (e: Exception) {
            listImageUrls.postValue(listOf(""))
            error.postValue("Image Not Found")
            println(e.message)

        }
        }
    }
}
