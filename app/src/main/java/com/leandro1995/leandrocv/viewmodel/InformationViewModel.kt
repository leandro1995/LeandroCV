package com.leandro1995.leandrocv.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.fragment.VidalResumeFragment

class InformationViewModel : ViewModel() {

    val shareSheetMutable: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val fragmentSelectMutable: MutableLiveData<Fragment> by lazy {
        MutableLiveData<Fragment>()
    }

    private val vidalResumeFragment = VidalResumeFragment()

    fun shareSheetOnclick() {
        shareSheetMutable.value = "LEANDRO"
    }

    fun vidalResumeSelect() {
        fragmentSelectMutable.value = vidalResumeFragment
    }
}