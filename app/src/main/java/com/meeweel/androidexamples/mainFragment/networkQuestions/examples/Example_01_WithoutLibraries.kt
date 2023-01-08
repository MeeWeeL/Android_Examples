package com.meeweel.androidexamples.mainFragment.networkQuestions.examples

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.meeweel.androidexamples.base.BasePagerExampleFragment
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class Example_01_WithoutLibraries : BasePagerExampleFragment() {

    private var counter = 1

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn2.setOnClickListener {

            val uri = URL("https://anilist.pserver.ru/api.php?q=animeTitleEn&id=${counter++}")
            Thread {
                var urlConnection: HttpsURLConnection? = null
                try {
                    urlConnection = uri.openConnection() as HttpsURLConnection
                    urlConnection.requestMethod = "GET" // установка метода получения данных
                    urlConnection.readTimeout = 20000 // установка таймаута
                    val reader =
                        BufferedReader(InputStreamReader(urlConnection.inputStream)) // читаем  данные в поток
                    requireActivity().runOnUiThread {
                        binding.text.text = reader.lines().collect(Collectors.joining("\n"))
                    }
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                    Log.e("", "Fail connection", e)
                    e.printStackTrace()
                } finally {
                    urlConnection?.disconnect()
                }
            }.start()
        }
    }
}