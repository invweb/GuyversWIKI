package com.zx_tole.guyverwiki.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.zx_tole.guyverwiki.adapter.CharactersAdapter
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentZoalordsBinding


class ZoalordsFragment : Fragment() {

    private var _binding: FragmentZoalordsBinding? = null

    private val binding get() = _binding!!
    private lateinit var adapter: CharactersAdapter

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

//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_ZoalordsFragment_to_IndexFragment)
//        }

        binding.zoalordsRecyclerView.setHasFixedSize(true)

        val zoalords: List<StoryCharacter> = createZoalordList()
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

    private fun createZoalordList(): List<StoryCharacter> {
        val archanfel = StoryCharacter(
            "Archanfel",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/1/1e/Alkanphel_%288%29.jpg/revision/latest?cb=20161210190727&path-prefix=ru"
        )
        val hamilcar = StoryCharacter(
            "Hamilcar Barcas",
            "https://static.wikia.nocookie.net/monster/images/c/c1/Balcus.jpg/revision/latest?cb=20170609185846",
        )
        val sin = StoryCharacter(
            "Sin Rubeo Amniculus",
            "https://i.pinimg.com/originals/7a/03/75/7a03750a1aaced671566f6d1eb705513.png"
        )
        val waferdanos = StoryCharacter(
            "Waferdanos",
            "https://static.wikia.nocookie.net/monster/images/3/3b/Waferdanos-manga.jpg/revision/latest?cb=20170611094553"
        )
        val friedrich = StoryCharacter("Friedrich von Purgstall",
            "https://comicvine.gamespot.com/a/uploads/original/10/108224/5681051-purgstall_zoalord.jpg"
        )
        val cabraal = StoryCharacter("Cabraal Khan",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/1/12/Cabral_Khan_%283%29.jpg/revision/latest?cb=20161129123723&path-prefix=ru"
        )
        val jabir = StoryCharacter("Jabir Ibn Hayyan",
            "https://i.pinimg.com/originals/4f/ef/16/4fef1690bbef5fabbd72faa6eb68f0c2.jpg"
        )
        val luggnagg = StoryCharacter("Luggnagg de Krumeggnic",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/9/98/Li_Yentsui_%281%29.png/revision/latest?cb=20161126183403&path-prefix=ru"
        )
        val li = StoryCharacter("Li Yentsui",
            "https://static.wikia.nocookie.net/guyver/images/9/90/Li-manga.jpg/revision/latest?cb=20150629054116"
        )
        val edward = StoryCharacter("Edward Caerleon",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/d/dd/Edward_Caerleon_%282%29.png/revision/latest?cb=20161127130723&path-prefix=ru"
        )

        val tuatha = StoryCharacter("Tuatha De Galenos",
            "https://static.wikia.nocookie.net/guyver/images/e/e6/Galenos.jpg/revision/latest?cb=20110207211304"
        )
        val richard = StoryCharacter("Richard Guyot",
            "https://i.pinimg.com/originals/6e/52/de/6e52de19585316a202f82f112b95511d.jpg"
        )
        val imakarum = StoryCharacter("Imakarum Mirabilis",
            "https://www.japan-legend.com/uploads/monthly_08_2012/post-2070-0-93409100-1344376016.jpg"
        )

        return listOf(
            archanfel,
            hamilcar,
            sin,
            waferdanos,
            friedrich,
            cabraal,
            jabir,
            luggnagg,
            li,
            edward,
            tuatha,
            richard,
            imakarum
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}