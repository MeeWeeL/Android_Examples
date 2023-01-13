package com.meeweel.androidexamples.mainFragment.async.coroutines

import androidx.fragment.app.Fragment
import com.meeweel.androidexamples.base.BasePagerFragment
import com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInFragment.DelayInFragment
import com.meeweel.androidexamples.mainFragment.async.coroutines.examples.delayInViewModel.DelayInViewModel
import com.meeweel.androidexamples.mainFragment.async.coroutines.examples.networkQueryWithException.NetworkQueryWithException

class CoroutinesFragment : BasePagerFragment() {
    override val fragmentsList: List<Fragment> = listOf(
        DelayInViewModel(),
        DelayInFragment(),
        NetworkQueryWithException()
    )
}