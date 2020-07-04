package com.leandro1995.leandrocv.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.adapter.ArticleAdapter
import com.leandro1995.leandrocv.databinding.FragmentArticleBinding
import com.leandro1995.leandrocv.viewmodel.ArticleViewModel

class ArticleFragment : Fragment() {

    private lateinit var articleBinding: FragmentArticleBinding
    private lateinit var articleViewModel: ArticleViewModel

    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleLinearLayoutManager: LinearLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view(inflater = inflater, container = container)
    }

    private fun view(inflater: LayoutInflater, container: ViewGroup?): View {
        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)

        articleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_article, container, false)

        created()

        return articleBinding.root
    }

    private fun created() {
        articleAdapter = ArticleAdapter()
        articleLinearLayoutManager = LinearLayoutManager(activity)
        articleLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        articleBinding.articleRecycler.apply {
            adapter = articleAdapter
            layoutManager = articleLinearLayoutManager
        }

        articleAdapter.notifyDataSetChanged()
    }
}