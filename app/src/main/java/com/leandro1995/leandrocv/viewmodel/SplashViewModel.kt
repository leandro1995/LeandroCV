package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.activity.InformationActivity
import com.leandro1995.leandrocv.activity.TermAndConditionActivity
import com.leandro1995.leandrocv.session.Preference

class SplashViewModel : ViewModel() {

    val termAndConditionMutable: MutableLiveData<Class<TermAndConditionActivity>> by lazy {
        MutableLiveData<Class<TermAndConditionActivity>>()
    }

    val informationMutable: MutableLiveData<Class<InformationActivity>> by lazy {
        MutableLiveData<Class<InformationActivity>>()
    }

    fun splashTimeOut() {
        if (Preference.status) {
            informationMutable.postValue(InformationActivity::class.java)
        } else {
            termAndConditionMutable.postValue(TermAndConditionActivity::class.java)
        }
    }
}