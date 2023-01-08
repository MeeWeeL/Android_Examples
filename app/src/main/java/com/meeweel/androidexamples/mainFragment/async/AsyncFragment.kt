package com.meeweel.androidexamples.mainFragment.async

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.meeweel.androidexamples.R
import com.meeweel.androidexamples.databinding.FragmentAsyncBinding

class AsyncFragment : Fragment() {

    private var _binding: FragmentAsyncBinding? = null
    internal val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = _binding ?: FragmentAsyncBinding.inflate(inflater, container, false)

        binding.coroutines.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_main_container)
                .navigate(R.id.action_asyncFragment_to_coroutinesFragment)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}