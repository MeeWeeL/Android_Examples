package com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInFragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.meeweel.androidexamples.base.BasePagerExampleFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DelayInFragment : BasePagerExampleFragment() {

    private var counter = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            title.text = "Изменение текста с задержкой в секунду через корутину в Fragment"
            post(counter.toString())
            btn3.visibility = View.VISIBLE
            btn3.text = "-1"
            btn3.setOnClickListener {
                lifecycleScope.launch {
                    delay(1000)
                    counter--
                    post(counter.toString())
                }
            }
            btn2.text = "+1"
            btn2.setOnClickListener {
                lifecycleScope.launch {
                    delay(1000)
                    counter++
                    post(counter.toString())
                }
            }
        }
    }

    private fun post(text: String) {
        binding.text.text = text
    }
}