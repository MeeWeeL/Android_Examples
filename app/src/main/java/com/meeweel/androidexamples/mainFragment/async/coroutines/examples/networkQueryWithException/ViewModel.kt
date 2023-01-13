package com.meeweel.androidexamples.mainFragment.async.coroutines.examples.networkQueryWithException

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meeweel.androidexamples.base.networkAnimeApi.coroutine.AnimeApiCoroutine
import com.meeweel.androidexamples.base.networkAnimeApi.coroutine.AnimeServiceCoroutine
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(private val api: AnimeApiCoroutine = AnimeServiceCoroutine.getService()): ViewModel() {
    private var counter = 0
    private val mutableText = MutableLiveData<String>()
    val text: LiveData<String> get() = mutableText

    fun next() {
        viewModelScope.launch(Dispatchers.IO) {
            counter++
            post(api.getTitleCoroutine(counter))
        }
    }

    private fun post(text: String) {
        mutableText.postValue(text)
    }
}