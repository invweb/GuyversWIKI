package com.zx_tole.guyverwiki.ui.vm

import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter

class ZoanoidsViewModel : ViewModel() {
    fun createZoanoidList(): List<StoryCharacter> {
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
}