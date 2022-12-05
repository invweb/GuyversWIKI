package com.zx_tole.guyverwiki.logic

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zx_tole.guyverwiki.R
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.data.StoryData
import timber.log.Timber
import java.io.InputStream
import java.nio.charset.Charset

object ParseCharacters {
    fun parseCharactersJson(context: Context): List<StoryCharacter> {
        val inputStream: InputStream = context.resources.openRawResource(
            R.raw.characters
        )

        val size: Int = inputStream.available()
        val buffer = ByteArray(size)

        inputStream.read(buffer)

        inputStream.close()

        val myType = object : TypeToken<StoryData>() {}.type
        val jsonStr = String(buffer, Charset.forName("UTF-8"))
        val gson = Gson()

        lateinit var char: StoryData
        try {
            char = gson.fromJson<StoryData>(
                jsonStr,
                myType
            )
        } catch (e: Exception) {
            Timber.d("parseCharactersJson method exception:")
            Timber.d(e)
        }

        return char.characters
    }
}