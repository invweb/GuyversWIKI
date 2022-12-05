package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.zx_tole.guyverwiki.R
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.data.StoryData
import com.zx_tole.guyverwiki.logic.ParseCharacters
import timber.log.Timber
import java.io.InputStream
import java.nio.charset.Charset

class CharactersViewModel: ViewModel() {
    fun parseCharacters(context: Context): List<StoryCharacter> {
        return ParseCharacters.parseCharactersJson(context)
    }
}