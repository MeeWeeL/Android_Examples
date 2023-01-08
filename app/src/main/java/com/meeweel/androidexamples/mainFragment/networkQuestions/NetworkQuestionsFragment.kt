package com.meeweel.androidexamples.mainFragment.networkQuestions

import com.meeweel.androidexamples.base.BasePagerFragment
import com.meeweel.androidexamples.mainFragment.networkQuestions.examples.Example_01_WithoutLibraries
import com.meeweel.androidexamples.mainFragment.networkQuestions.examples.Example_02_OkHttp
import com.meeweel.androidexamples.mainFragment.networkQuestions.examples.Example_03_OkHttpAndRetrofit

class NetworkQuestionsFragment : BasePagerFragment() {

    override val fragmentsList = listOf(
        Example_01_WithoutLibraries(),
        Example_02_OkHttp(),
        Example_03_OkHttpAndRetrofit()
    )
}