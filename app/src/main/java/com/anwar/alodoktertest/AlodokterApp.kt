package com.anwar.alodoktertest

import android.app.Application

class AlodokterApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
         lateinit var instance: AlodokterApp
            private set
    }

}
