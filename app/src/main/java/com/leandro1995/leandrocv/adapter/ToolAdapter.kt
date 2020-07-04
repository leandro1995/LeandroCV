package com.leandro1995.leandrocv.adapter

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.model.Tool
import kotlinx.android.synthetic.main.item_tool.view.*

class ToolAdapter constructor(
    private var activity: Activity,
    private var toolList: MutableList<Tool>
) :
    RecyclerView.Adapter<ToolAdapter.ToolHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToolHolder {
        return ToolHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_tool, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return toolList.size
    }

    override fun onBindViewHolder(holder: ToolHolder, position: Int) {
        holder.itemView.toolImage.setImageResource(toolList[position].image)
        holder.itemView.nameToolText.text = toolList[position].name
    }

    inner class ToolHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.contentLinear.setOnClickListener {
                activity.startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(toolList[adapterPosition].url)
                    )
                )
            }
        }
    }
}