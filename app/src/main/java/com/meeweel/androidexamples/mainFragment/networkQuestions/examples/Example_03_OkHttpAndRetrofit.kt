package com.meeweel.androidexamples.mainFragment.networkQuestions.examples

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.meeweel.androidexamples.mainFragment.networkQuestions.BaseExampleFragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.net.URL
import java.util.concurrent.TimeUnit

class Example_03_OkHttpAndRetrofit : BaseExampleFragment() {


    private var counter = 1

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn.setOnClickListener {

            val url = URL("https://anilist.pserver.ru/")

            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(25, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.createSynchronous())
                .client(client)
                .build()

            val service = retrofit.create(Service::class.java)

            service.getTitle(counter++)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    binding.text.text = response
                }, { e ->
                    Toast.makeText(requireContext(), e.message, Toast.LENGTH_SHORT).show()
                })
        }
    }

    interface Service {
        @GET("api.php?q=animeTitleEn")
        fun getTitle(@Query("id") id: Int): Single<String>
    }
}