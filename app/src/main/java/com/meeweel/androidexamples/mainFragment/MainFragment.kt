package com.meeweel.androidexamples.mainFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.meeweel.androidexamples.R
import com.meeweel.androidexamples.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = _binding ?: FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNetworkQuestions.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_main_container)
                .navigate(R.id.action_mainFragment_to_networkQuestionsFragment)
        }
        binding.btnDialogs.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_main_container)
                .navigate(R.id.action_mainFragment_to_dialogsFragment)
        }
        binding.btnAsyncTasks.setOnClickListener {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_main_container)
                .navigate(R.id.action_mainFragment_to_asyncFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}