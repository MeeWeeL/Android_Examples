package com.meeweel.androidexamples.base.networkAnimeApi.rxJava

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiRxJava {

    @GET("api.php?q=animeTitleEn")
    fun getTitleRxJava(@Query("id") id: Int): Single<String>
}