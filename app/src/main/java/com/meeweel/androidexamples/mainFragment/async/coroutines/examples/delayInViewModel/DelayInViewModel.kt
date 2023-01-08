package com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInViewModel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.meeweel.androidexamples.base.BasePagerExampleFragment

class DelayInViewModel: BasePagerExampleFragment() {

    private val viewModel by lazy {
        ViewModelProvider(this)[ViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner) { text -> post(text) }
        binding.apply {
            title.text = "Изменение текста с задержкой в секунду через корутину в ViewModel"
            btn3.visibility = View.VISIBLE
            btn3.text = "-1"
            btn3.setOnClickListener {
                viewModel.minus()
            }
            btn2.text = "+1"
            btn2.setOnClickListener {
                viewModel.plus()
            }
        }
    }

    private fun post(text: String) {
        binding.text.text = text
    }
}