package com.zx_tole.guyverwiki.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentGuyversBinding

class GuyversFragment : Fragment() {
    private var _binding: FragmentGuyversBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

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

        val guyvers: List<StoryCharacter> = createGuyverList()
        adapter = CharactersAdapter()
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
    }

    private fun createGuyverList(): List<StoryCharacter> {
        val guyverOne = StoryCharacter(
            "Шо Фукамачи",
            "https://avatars.mds.yandex.net/i?id=9d9c047d1a7e9d1cc8c21b6a1d16e750-3584061-images-thumbs&n=13"
        )
        val guyverTwo = StoryCharacter(
            "Освальд Лискер",
            "https://steamuserimages-a.akamaihd.net/ugc/89347228429379391/A1C781B8AE3BEDF7EA24DEC3EF88D8C9E500ABDD/?imw=512&amp;imh=289&amp;ima=fit&amp;impolicy=Letterbox&amp;imcolor=%23000000&amp;letterbox=true"
        )
        val guyverThree = StoryCharacter(
            "Агито Макисима",
            "https://i.pinimg.com/originals/af/e5/b6/afe5b6ec4af56febe13e26dccff321c5.jpg"
        )
        return listOf(
            guyverOne,
            guyverTwo,
            guyverThree
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}