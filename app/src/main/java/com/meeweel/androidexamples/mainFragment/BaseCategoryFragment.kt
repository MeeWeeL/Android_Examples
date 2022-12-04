package com.meeweel.androidexamples.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.meeweel.androidexamples.databinding.FragmentNetworkQuestionsBinding

abstract class BaseCategoryFragment : Fragment() {

    private var _binding: FragmentNetworkQuestionsBinding? = null
    private val binding get() = _binding!!
    abstract val fragmentsList: List<Fragment>
    private var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = _binding ?: FragmentNetworkQuestionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewPagerAdapter == null) {
            viewPagerAdapter = ViewPagerAdapter(this)
            binding.viewPager.adapter = viewPagerAdapter
        }
    }

    inner class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount() = fragmentsList.count()

        override fun createFragment(position: Int): Fragment {
            return fragmentsList[position]
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}