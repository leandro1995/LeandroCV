package com.leandro1995.leandrocv.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.model.PlayStore
import kotlinx.android.synthetic.main.item_play_store.view.*

class PlayStoreAdapter constructor(
    private var activity: Activity,
    private var playStoreList: MutableList<PlayStore>
) :
    RecyclerView.Adapter<PlayStoreAdapter.PlayStoreHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayStoreHolder {
        return PlayStoreHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_play_store, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return playStoreList.size
    }

    override fun onBindViewHolder(holder: PlayStoreHolder, position: Int) {
        holder.itemView.namePlayStoreText.text = playStoreList[position].name
    }

    inner class PlayStoreHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.contentLinear.setOnClickListener {
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(playStoreList[adapterPosition].url)
                    )
                )
            }
        }
    }
}