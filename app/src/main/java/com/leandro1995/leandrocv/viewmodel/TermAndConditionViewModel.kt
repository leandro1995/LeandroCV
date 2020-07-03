package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.activity.InformationActivity
import com.leandro1995.leandrocv.session.Preference

class TermAndConditionViewModel : ViewModel() {

    val styleButtonMutable: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val acceptMutable: MutableLiveData<Class<InformationActivity>> by lazy {
        MutableLiveData<Class<InformationActivity>>()
    }

    private var acceptStatus = false

    fun styleButton(status: Boolean) {
        acceptStatus = status

        styleButtonMutable.value = if (status) {
            R.style.ActiveButton
        } else {
            R.style.DeactivatedButton
        }
    }

    fun acceptOnclick() {
        if (acceptStatus) {
            Preference.status = acceptStatus
            acceptMutable.value = InformationActivity::class.java
        } else {
            Preference.status = acceptStatus
        }
    }
}