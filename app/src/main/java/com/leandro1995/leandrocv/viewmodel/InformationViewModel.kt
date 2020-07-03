package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationViewModel : ViewModel() {

    val shareSheetMutable: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun shareSheetOnclick() {
        shareSheetMutable.value = "LEANDRO"
    }
}