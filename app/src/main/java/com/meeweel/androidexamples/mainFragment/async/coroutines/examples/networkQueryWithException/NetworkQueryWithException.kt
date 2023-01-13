package com.meeweel.androidexamples.mainFragment.async.coroutines.examples.networkQueryWithException

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.meeweel.androidexamples.base.BasePagerExampleFragment

class NetworkQueryWithException: BasePagerExampleFragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner) { text -> post(text) }
        binding.apply {
            title.text = "Текст из сетевого запроса через корутину"
            btn2.text = "NEXT"
            btn2.setOnClickListener {
                viewModel.next()
            }
        }
    }

    private fun post(text: String) {
        binding.text.text = text
    }
}