package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseCharactersUseCase

class CharactersViewModel: ViewModel() {
    fun parseCharacters(context: Context): List<StoryCharacter> {
        return ParseCharactersUseCase.parseCharactersJson(context)
    }
}