package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.model.Contact
import com.leandro1995.leandrocv.model.Tool

class VidalResumeViewModel : ViewModel() {

    val toolMutable: MutableLiveData<MutableList<Tool>> by lazy {
        MutableLiveData<MutableList<Tool>>()
    }

    val contactMutable: MutableLiveData<MutableList<Contact>> by lazy {
        MutableLiveData<MutableList<Contact>>()
    }

    fun toolInit() {
        toolMutable.value = Setting.TOOL_LIST
    }

    fun contactInit() {
        contactMutable.value = Setting.CONTACT_LIST
    }
}