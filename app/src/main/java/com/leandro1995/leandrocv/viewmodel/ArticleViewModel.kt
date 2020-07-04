package com.leandro1995.leandrocv.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.model.Article

class ArticleViewModel : ViewModel() {

    val articleMutable: MutableLiveData<MutableList<Article>> by lazy {
        MutableLiveData<MutableList<Article>>()
    }

    fun articleInit() {
        articleMutable.value = Setting.ARTICLE_lIST
    }
}