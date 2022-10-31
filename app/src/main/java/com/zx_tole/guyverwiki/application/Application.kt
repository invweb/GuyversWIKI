package com.zx_tole.guyverwiki.application

import timber.log.Timber

class Application : android.app.Application() {
    init {
        Timber.plant(Timber.DebugTree())

        Timber.d("Guyver wiki application debug log")
    }
}