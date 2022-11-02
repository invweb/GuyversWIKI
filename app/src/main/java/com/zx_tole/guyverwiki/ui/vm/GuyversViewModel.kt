package com.zx_tole.guyverwiki.ui.vm

import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter

class GuyversViewModel: ViewModel() {
    fun createGuyverList(): List<StoryCharacter> {
        val guyverOne = StoryCharacter(
            "Шо(Сё) Фукамачи",
            "главный герой. Сё — 17-ти летний ученик второго класса одной из старших " +
                    "школ Японии. Его отец — Фукамати Фумио, мать — Фукамати Акиэ, " +
                    "лучший друг — Сэгава Тэцуро, подруга в которую он влюблён — " +
                    "Сэгава Мидзуки. После того как случайно заполучил Блок Био-Брони " +
                    "и трансформировался в Гайвера, он вместе с друзьями и отцом попал " +
                    "под прицел Кроноса, пытающегося вернуть утраченный Юнит.",
            "https://avatars.mds.yandex.net/i?id=9d9c047d1a7e9d1cc8c21b6a1d16e750-3584061-images-thumbs&n=13"
        )
        val guyverTwo = StoryCharacter(
            "Освальд Лискер",
            "",
            "https://steamuserimages-a.akamaihd.net/ugc/89347228429379391/A1C781B8AE3BEDF7EA24DEC3EF88D8C9E500ABDD/?imw=512&amp;imh=289&amp;ima=fit&amp;impolicy=Letterbox&amp;imcolor=%23000000&amp;letterbox=true"
        )
        val guyverThree = StoryCharacter(
            "Агито Макисима",
            "",
            "https://i.pinimg.com/originals/af/e5/b6/afe5b6ec4af56febe13e26dccff321c5.jpg"
        )
        return listOf(
            guyverOne,
            guyverTwo,
            guyverThree
        )
    }
}