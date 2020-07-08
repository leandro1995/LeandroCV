package com.leandro1995.leandrocv.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.fragment.ArticleFragment
import com.leandro1995.leandrocv.fragment.PlayStoreFragment
import com.leandro1995.leandrocv.fragment.VidalResumeFragment

class InformationViewModel : ViewModel() {

    val shareSheetMutable: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val fragmentSelectMutable: MutableLiveData<Fragment> by lazy {
        MutableLiveData<Fragment>()
    }

    private val vidalResumeFragment = VidalResumeFragment()
    private val articleFragment = ArticleFragment()
    private val playStoreFragment = PlayStoreFragment()

    fun shareSheetOnclick() {
        shareSheetMutable.value = Setting.PLAY_STORE
    }

    fun menuSelect(menuId: Int) {
        when (menuId) {
            R.id.information_navigation -> {
                vidalResumeSelect()
            }
            R.id.article_navigation -> {
                articleSelect()
            }
            else -> {
                playStoreSelect()
            }
        }
    }

    fun vidalResumeSelect() {
        fragmentSelectMutable.value = vidalResumeFragment
    }

    private fun articleSelect() {
        fragmentSelectMutable.value = articleFragment
    }

    private fun playStoreSelect() {
        fragmentSelectMutable.value = playStoreFragment
    }
}