package com.zx_tole.guyverwiki.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentGuyversBinding
import com.zx_tole.guyverwiki.ui.vm.GuyversViewModel

class GuyversFragment : Fragment() {
    private var _binding: FragmentGuyversBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

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

        val guyvers: List<StoryCharacter> = viewModel.createGuyverList()
        adapter = CharactersAdapter()

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

        viewModel.parseGuyversJson(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}