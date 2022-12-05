package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseGuyversUseCase

class GuyversViewModel: ViewModel() {

    fun parseGuyversJson(context: Context): List<StoryCharacter> {
        return ParseGuyversUseCase.parseGuyversJson(context)
    }
}