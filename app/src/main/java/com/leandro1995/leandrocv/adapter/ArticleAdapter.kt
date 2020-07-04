package com.leandro1995.leandrocv.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter constructor(
    private var activity: Activity,
    private var articleList: MutableList<Article>
) :
    RecyclerView.Adapter<ArticleAdapter.ArticleHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHolder {
        return ArticleHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_article, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleHolder, position: Int) {
        holder.itemView.articleImage.setImageResource(articleList[position].image)
        holder.itemView.nameArticleText.text = articleList[position].name
    }

    inner class ArticleHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.contentLinear.setOnClickListener {
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(articleList[adapterPosition].url)
                    )
                )
            }
        }
    }
}