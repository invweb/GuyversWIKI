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
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {
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

        val characters: List<StoryCharacter> = createCharactersList()
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

    private fun createCharactersList(): List<StoryCharacter> {
        val characterOne = StoryCharacter(
            "Masaki Murakami",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/c/c7/Murakami_Masaki_%282%29.jpg/revision/latest/scale-to-width-down/139?cb=20161201162413&path-prefix=ru"
        )

        val characterTwo = StoryCharacter(
            "Мидзуки Сэгава",
            "https://comicvine.gamespot.com/a/uploads/scale_medium/1/19373/1069965-mizuki.jpg"
        )

        return listOf(
            characterOne,
            characterTwo
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}