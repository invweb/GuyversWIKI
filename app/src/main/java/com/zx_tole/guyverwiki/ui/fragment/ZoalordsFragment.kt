package com.zx_tole.guyverwiki.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentZoalordsBinding
import com.zx_tole.guyverwiki.ui.vm.ZoalordsViewModel


class ZoalordsFragment : Fragment() {

    private var _binding: FragmentZoalordsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

    private val viewModel: ZoalordsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentZoalordsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.zoalordsRecyclerView.setHasFixedSize(true)

        val zoalords: List<StoryCharacter> = viewModel.createZoalordList()
        adapter = CharactersAdapter()

        adapter.setNavController(findNavController())
        adapter.setItems(zoalords)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.zoalordsRecyclerView.layoutManager = linearLayoutManager
        binding.zoalordsRecyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            binding.zoalordsRecyclerView.context,
            linearLayoutManager.orientation
        )
        binding.zoalordsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}