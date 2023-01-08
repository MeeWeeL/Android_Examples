package com.meeweel.androidexamples.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meeweel.androidexamples.databinding.FragmentPagerExampleBinding

open class BasePagerExampleFragment : Fragment() {

    private var _binding: FragmentPagerExampleBinding? = null
    internal val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            _binding ?: FragmentPagerExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.title.text = this.javaClass.simpleName
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}