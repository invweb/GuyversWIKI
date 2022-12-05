package com.zx_tole.guyverwiki.presentation.vm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zx_tole.guyverwiki.data.StoryCharacter
import com.zx_tole.guyverwiki.logic.ParseGuyversUseCase
import kotlinx.coroutines.async

class GuyversViewModel: ViewModel() {

    suspend fun parseGuyversJson(context: Context): List<StoryCharacter> {
        val deferred = viewModelScope.async {
            ParseGuyversUseCase.parseGuyversJson(context)
        }

        return deferred.await()
    }
}