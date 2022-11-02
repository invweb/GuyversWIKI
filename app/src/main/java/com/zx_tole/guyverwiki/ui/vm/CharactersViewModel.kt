package com.zx_tole.guyverwiki.ui.vm

import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter

class CharactersViewModel: ViewModel() {
    fun createCharactersList(): List<StoryCharacter> {
        val characterOne = StoryCharacter(
            "Masaki Murakami",
            "",
            "https://static.wikia.nocookie.net/anime-characters-fight/images/c/c7/Murakami_Masaki_%282%29.jpg/revision/latest/scale-to-width-down/139?cb=20161201162413&path-prefix=ru"
        )

        val characterTwo = StoryCharacter(
            "Мидзуки Сэгава",
            "",
            "https://comicvine.gamespot.com/a/uploads/scale_medium/1/19373/1069965-mizuki.jpg"
        )

        return listOf(
            characterOne,
            characterTwo
        )
    }
}