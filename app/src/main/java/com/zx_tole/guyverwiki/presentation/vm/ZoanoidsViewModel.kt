package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseZoanoidsUseCase

class ZoanoidsViewModel : ViewModel() {
    fun parseZoanoidsJson(context: Context): List<StoryCharacter> {
        return ParseZoanoidsUseCase.parseZoanoidsJson(context)
    }
}