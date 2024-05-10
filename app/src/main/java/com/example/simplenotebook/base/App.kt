package com.example.simplenotebook.base

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    // At the top level of your kotlin file:
    override fun onCreate() {
        super.onCreate()
    }
}