package com.zx_tole.guyverwiki.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zx_tole.guyverwiki.R
import com.zx_tole.guyverwiki.databinding.FragmentIndexBinding

class IndexFragment : Fragment() {

    private var _binding: FragmentIndexBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIndexBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.zoalordsItem.setOnClickListener {
            findNavController().navigate(R.id.action_IndexFragment_to_ZoalordsFragment)
        }

        binding.zoanoidsItem.setOnClickListener {
            findNavController().navigate(R.id.action_IndexFragment_to_ZoanoidsFragment)
        }

        binding.guyversItem.setOnClickListener {
            findNavController().navigate(R.id.action_IndexFragment_to_GuyversFragment)
        }

        binding.guyverStoryCharactersItem.setOnClickListener {
            findNavController().navigate(R.id.action_IndexFragment_to_CharactersFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}