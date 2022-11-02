package com.zx_tole.guyverwiki.ui.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zx_tole.guyverwiki.R
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.data.StoryData
import timber.log.Timber
import java.io.InputStream
import java.nio.charset.Charset


class GuyversViewModel: ViewModel() {

    fun parseGuyversJson(context: Context) {
        val inputStream: InputStream = context.resources.openRawResource(
            R.raw.guyvers
        )

        val size: Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)

        inputStream.close()

        val myType = object : TypeToken<StoryData>() {}.type
        val jsonStr = String(buffer, Charset.forName("UTF-8"))
        val gson = Gson()

        try {
            val char = gson.fromJson<StoryData>(
                jsonStr,
                myType
            )
            Timber.d("" + char.guyvers.size)
        } catch (e: Exception) {
             Timber.d("")
        }
    }

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
            "Освальд А. Лискер",
            "Агент Хроноса и Инспектор по перевозке предметов из одного места в " +
                    "другое, инспектировал различные филиалы Хроноса, отслеживал их прогресс и сообщал о " +
                    "любых инцидентах в штаб-квартиру Хроноса. Лискер находился в Японии, чтобы " +
                    "проследить за перемещением бездействующих подразделений " +
                    "Гайвера в штаб-квартиру Хроноса, и был очень раздосадован, обнаружив, " +
                    "что японский директор, Гензо Макисима, умудрился их потерять.",
            "https://steamuserimages-a.akamaihd.net/ugc/89347228429379391/A1C781B8AE3BEDF7EA24DEC3EF88D8C9E500ABDD/?imw=512&amp;imh=289&amp;ima=fit&amp;impolicy=Letterbox&amp;imcolor=%23000000&amp;letterbox=true"
        )
        val guyverThree = StoryCharacter(
            "Агито Макисима",
            "студент 3-го курса одной из старших школ Японии, " +
                    "18 лет (на момент начала манги и аниме). Его родной отец " +
                    "был разорён Гэндзо Макисимой, который приходился ему родным " +
                    "дядей. Вскоре после этого мать Агито скончалась, " +
                    "после чего его отец свёл счёты с жизнью. Впоследствии " +
                    "Гэндзо усыновил Агито, но лишь для того, чтобы использовать " +
                    "его для продвижения по карьерной лестнице в Кроносе. " +
                    "Агито понимал это и ненавидел за это как Гэндзо, так и Кронос. " +
                    "Это стало одной из причин организации им похищения модулей " +
                    "Гайвер. Ему удалось заполучить один модуль и стать " +
                    "Гайвером III. В дальнейшем он использовал Сё (Гайвер I) " +
                    "для уничтожения японского филиала Кроноса, " +
                    "но этим он не удовлетворился. Имея силу Гайвера Агито " +
                    "вознамерился стать властелином мира. Он и в дальнейшем " +
                    "использовал Сё в своих целях, участвовал вместе с ним в " +
                    "уничтожении базы Кроноса на горе Минаками и Реликта. " +
                    "В отсутствие Сё (когда тот находился в Коконе, создавая " +
                    "Гигантика) организовал организацию сопротивления Молния Зевса",
            "https://i.pinimg.com/originals/af/e5/b6/afe5b6ec4af56febe13e26dccff321c5.jpg"
        )
        return listOf(
            guyverOne,
            guyverTwo,
            guyverThree
        )
    }
}