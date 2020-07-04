package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.model.PlayStore

class PlayStoreViewModel : ViewModel() {

    val playStoreMutable: MutableLiveData<MutableList<PlayStore>> by lazy {
        MutableLiveData<MutableList<PlayStore>>()
    }

    fun playStoreInit() {
        playStoreMutable.value = Setting.PLAY_STORE_LIST
    }
}