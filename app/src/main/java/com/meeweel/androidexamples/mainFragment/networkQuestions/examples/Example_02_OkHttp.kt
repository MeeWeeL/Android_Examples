package com.meeweel.androidexamples.mainFragment.networkQuestions.examples

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.meeweel.androidexamples.mainFragment.networkQuestions.BaseExampleFragment
import okhttp3.*
import java.io.IOException
import java.net.URL
import java.util.concurrent.TimeUnit


class Example_02_OkHttp : BaseExampleFragment() {


    private var counter = 1

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {

            val url = URL("https://anilist.pserver.ru/api.php?q=animeTitleEn&id=${counter++}")

            val request: Request = Request.Builder()
                .url(url)
                .get()
                .build()

            val client = OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call, response: Response) {
                    val responseString = response.body!!.string()
                    requireActivity().runOnUiThread {
                        binding.text.text = responseString
                    }
                }
            })
        }
    }
}