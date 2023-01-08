package com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ViewModel: ViewModel() {
    private var counter = 0
    private val mutableText = MutableLiveData<String>()
    val text: LiveData<String> get() = mutableText

    init {
        post()
    }

    fun plus() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000)
            counter++
            post()
        }
    }

    fun minus() {
        viewModelScope.launch {
            delay(1000)
            counter--
            post()
        }
    }

    private fun post() {
        mutableText.postValue(counter.toString())
    }
}