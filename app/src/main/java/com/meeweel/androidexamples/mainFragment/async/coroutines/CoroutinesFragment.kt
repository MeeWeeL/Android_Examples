package com.meeweel.androidexamples.mainFragment.async.coroutines

import androidx.fragment.app.Fragment
import com.meeweel.androidexamples.base.BasePagerFragment
import com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInViewModel.DelayInViewModel

class CoroutinesFragment : BasePagerFragment() {
    override val fragmentsList: List<Fragment> = listOf(
        DelayInViewModel()
    )
}