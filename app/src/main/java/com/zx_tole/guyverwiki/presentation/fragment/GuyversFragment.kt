package com.zx_tole.guyverwiki.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentGuyversBinding
import com.zx_tole.guyverwiki.presentation.adapter.GuyversAdapter
import com.zx_tole.guyverwiki.presentation.vm.GuyversViewModel
import kotlinx.coroutines.launch

class GuyversFragment : Fragment() {
    private var _binding: FragmentGuyversBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: GuyversAdapter

    private val viewModel: GuyversViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuyversBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.guyversRecyclerView.setHasFixedSize(true)

        lateinit var guyvers: List<StoryCharacter>
        lifecycleScope.launch {
            guyvers = viewModel.parseGuyversJson(requireContext())
        }

        adapter = GuyversAdapter()

        adapter.setNavController(findNavController())
        adapter.setItems(guyvers)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.guyversRecyclerView.layoutManager = linearLayoutManager
        binding.guyversRecyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            binding.guyversRecyclerView.context,
            linearLayoutManager.orientation
        )
        binding.guyversRecyclerView.addItemDecoration(dividerItemDecoration)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}