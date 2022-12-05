package com.zx_tole.guyverwiki.presentation.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.presentation.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentZoalordsBinding
import com.zx_tole.guyverwiki.presentation.vm.ZoalordsViewModel
import kotlinx.coroutines.launch
import timber.log.Timber


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

        lateinit var zoalords: List<StoryCharacter>
        lifecycleScope.launch {
            zoalords = viewModel.parseZoalordsJson(requireContext())
            Timber.d("")
        }
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