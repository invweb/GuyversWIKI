package com.zx_tole.guyverwiki.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.databinding.FragmentCharacterBinding
import com.zx_tole.guyverwiki.tech.CHARACTER
import timber.log.Timber

class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val storyCharacter: StoryCharacter? = requireArguments().getParcelable(
            CHARACTER,
            StoryCharacter::class.java
        )

        binding.storyCharacter = storyCharacter

        Timber.d("")
    }
}