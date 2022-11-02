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

    fun parseGuyversJson(context: Context): List<StoryCharacter> {
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

        lateinit var char: StoryData
        try {
            char = gson.fromJson<StoryData>(
                jsonStr,
                myType
            )
        } catch (e: Exception) {
             Timber.d("")
        }

        return char.guyvers
    }
}