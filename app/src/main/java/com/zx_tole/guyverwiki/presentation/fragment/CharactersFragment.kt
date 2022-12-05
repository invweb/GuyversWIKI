package com.zx_tole.guyverwiki.presentation.fragment

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
import com.zx_tole.guyverwiki.presentation.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentCharactersBinding
import com.zx_tole.guyverwiki.presentation.vm.CharactersViewModel

class CharactersFragment : Fragment() {
    private val viewModel: CharactersViewModel by viewModels()
    private var _binding: FragmentCharactersBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.charactersRecyclerView.setHasFixedSize(true)

        val characters: List<StoryCharacter> = viewModel.parseCharacters(requireContext())
        adapter = CharactersAdapter()

        adapter.setNavController(findNavController())
        adapter.setItems(characters)

        val linearLayoutManager = LinearLayoutManager(requireContext())
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        binding.charactersRecyclerView.layoutManager = linearLayoutManager
        binding.charactersRecyclerView.adapter = adapter

        val dividerItemDecoration = DividerItemDecoration(
            binding.charactersRecyclerView.context,
            linearLayoutManager.orientation
        )
        binding.charactersRecyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}