package com.leandro1995.leandrocv.application

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.leandro1995.leandrocv.session.Preference

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        Preference.instance(context = applicationContext)
        Fresco.initialize(this)
    }
}