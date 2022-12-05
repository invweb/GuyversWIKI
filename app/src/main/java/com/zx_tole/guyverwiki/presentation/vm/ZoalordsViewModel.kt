package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseZoalordsUseCase
import kotlinx.coroutines.async

class ZoalordsViewModel : ViewModel() {
    suspend fun parseZoalordsJson(context: Context): List<StoryCharacter> {
        val deferred = viewModelScope.async {
            ParseZoalordsUseCase.parseZoalordsJson(context)
        }

        return deferred.await()
    }
}