package com.leandro1995.leandrocv.adapter

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.model.Contact
import kotlinx.android.synthetic.main.item_contact.view.*

class ContactAdapter constructor(
    private var activity: Activity,
    private var contactList: MutableList<Contact>
) :
    RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        return ContactHolder(
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_contact, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.itemView.contactImage.setImageResource(contactList[position].image)
        holder.itemView.nameContactText.text = contactList[position].name
    }

    inner class ContactHolder constructor(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.contentLinear.setOnClickListener {
                when (adapterPosition) {
                    0 -> {
                        activity.startActivity(Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:")
                            putExtra(Intent.EXTRA_EMAIL, arrayOf(Setting.EMAIL))
                            putExtra(Intent.EXTRA_SUBJECT, Setting.SUBJECT)
                        })
                    }
                    1 -> {
                        activity.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(contactList[adapterPosition].url)
                            )
                        )
                    }
                    else -> {
                        if (ContextCompat.checkSelfPermission(
                                activity,
                                Manifest.permission.CALL_PHONE
                            )
                            != PackageManager.PERMISSION_GRANTED
                        ) {
                            ActivityCompat.requestPermissions(
                                activity,
                                arrayOf(Manifest.permission.CALL_PHONE),
                                Setting.CALL_PHONE
                            )
                        } else {
                            activity.startActivity(
                                Intent(
                                    Intent.ACTION_CALL,
                                    Uri.parse("tel:${contactList[adapterPosition].phone}")
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}