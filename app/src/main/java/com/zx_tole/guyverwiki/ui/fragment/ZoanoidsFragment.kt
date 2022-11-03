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
import com.zx_tole.guyverwiki.databinding.FragmentZoanoidsBinding
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.ui.vm.ZoanoidsViewModel

class ZoanoidsFragment : Fragment() {
    private var _binding: FragmentZoanoidsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

    private val viewModel: ZoanoidsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentZoanoidsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.zoanoidsRecyclerView.setHasFixedSize(true)

        val zoanoids: List<StoryCharacter> = viewModel.parseZoanoidsJson(requireContext())
        adapter = CharactersAdapter()

        adapter.setNavController(findNavController())
        adapter.setItems(zoanoids)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.zoanoidsRecyclerView.layoutManager = linearLayoutManager
        binding.zoanoidsRecyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            binding.zoanoidsRecyclerView.context,
            linearLayoutManager.orientation
        )
        binding.zoanoidsRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}