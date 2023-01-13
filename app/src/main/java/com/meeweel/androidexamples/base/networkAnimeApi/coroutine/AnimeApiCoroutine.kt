package com.meeweel.androidexamples.base.networkAnimeApi.coroutine

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiCoroutine {

    @GET("api.php?q=animeTitleEn")
    suspend fun getTitleCoroutine(@Query("id") id: Int): String
}