package com.meeweel.androidexamples.mainFragment.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meeweel.androidexamples.databinding.FragmentDialogsBinding

open class BaseExampleFragment : Fragment() {

    private var _binding: FragmentDialogsBinding? = null
    internal val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = _binding ?: FragmentDialogsBinding.inflate(inflater, container, false)
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