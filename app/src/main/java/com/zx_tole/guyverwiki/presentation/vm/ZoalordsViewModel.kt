package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseZoalordsUseCase

class ZoalordsViewModel : ViewModel() {
    fun parseZoalordsJson(context: Context): List<StoryCharacter> {
        return ParseZoalordsUseCase.parseZoalordsJson(context)
    }
}