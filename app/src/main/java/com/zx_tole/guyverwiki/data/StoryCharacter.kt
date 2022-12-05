package com.zx_tole.guyverwiki.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class StoryCharacter(val name: String?, val description: String?, val imageLink: String?, val comment: String?): Parcelable