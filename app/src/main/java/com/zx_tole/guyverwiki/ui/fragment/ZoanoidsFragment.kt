package com.zx_tole.guyverwiki.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.databinding.FragmentZoanoidsBinding
import com.zx_tole.guyverwiki.data.StoryCharacter

class ZoanoidsFragment : Fragment() {
    private var _binding: FragmentZoanoidsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

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

        val zoanoids: List<StoryCharacter> = createZoanoidList()
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

    private fun createZoanoidList(): List<StoryCharacter> {
        val cadan = StoryCharacter(
            "Cadan",
            "",
            "https://static.wikia.nocookie.net/guyver/images/4/4f/Cadan.jpg/revision/latest?cb=20101222183237"
        )
        val citiciss = StoryCharacter(
            "Citiciss",
            "",
            "https://static.wikia.nocookie.net/guyver/images/4/45/Citiciss.jpg/revision/latest?cb=20101222000644"
        )
        val brelimos = StoryCharacter(
            "Brelimos",
            "",
            "https://static.wikia.nocookie.net/guyver/images/1/1d/Brelimos.jpg/revision/latest?cb=20101223180545"
        )
        return listOf(
            cadan,
            citiciss,
            brelimos
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}