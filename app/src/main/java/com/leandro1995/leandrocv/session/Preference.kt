package com.leandro1995.leandrocv.session

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

object Preference {

    private const val preferenceName = "leandroCV"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var statusUser = "statusUser"

    @SuppressLint("CommitPrefEdits")
    fun instance(context: Context) {
        sharedPreferences = context.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    var status: Boolean
        get() = sharedPreferences.getBoolean(statusUser, false)
        set(value) {
            editor.putBoolean(statusUser, value).commit()
        }
}