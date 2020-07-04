package com.leandro1995.leandrocv.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.adapter.ContactAdapter
import com.leandro1995.leandrocv.adapter.ToolAdapter
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.databinding.FragmentVidalResumeBinding
import com.leandro1995.leandrocv.model.Contact
import com.leandro1995.leandrocv.model.Tool
import com.leandro1995.leandrocv.viewmodel.VidalResumeViewModel

class VidalResumeFragment : Fragment() {

    private lateinit var vidalResumeBinding: FragmentVidalResumeBinding
    private lateinit var vidalResumeViewModel: VidalResumeViewModel

    private lateinit var toolAdapter: ToolAdapter
    private lateinit var toolLinearLayoutManager: LinearLayoutManager
    private lateinit var contactAdapter: ContactAdapter
    private lateinit var contactLinearLayoutManager: LinearLayoutManager

    private val toolList = mutableListOf<Tool>()
    private val contactList = mutableListOf<Contact>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view(inflater = inflater, container = container)
    }

    private fun view(inflater: LayoutInflater, container: ViewGroup?): View {
        vidalResumeViewModel = ViewModelProvider(this).get(VidalResumeViewModel::class.java)

        observer()

        vidalResumeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vidal_resume, container, false)
        vidalResumeBinding.vidalResumeModel = vidalResumeViewModel

        vidalResumeBinding.imageView.setImageURI(Setting.IMAGE_PROFILE)

        created()

        return vidalResumeBinding.root
    }

    private fun created() {
        vidalResumeViewModel.toolInit()
        vidalResumeViewModel.contactInit()

        toolAdapter = ToolAdapter(activity = this.activity!!, toolList = toolList)
        toolLinearLayoutManager = LinearLayoutManager(activity)
        toolLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        vidalResumeBinding.toolRecycler.apply {
            adapter = toolAdapter
            layoutManager = toolLinearLayoutManager
        }

        toolAdapter.notifyDataSetChanged()

        contactAdapter = ContactAdapter(activity = this.activity!!, contactList = contactList)

        contactLinearLayoutManager = LinearLayoutManager(activity)
        contactLinearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        vidalResumeBinding.contactRecycler.apply {
            adapter = contactAdapter
            layoutManager = contactLinearLayoutManager
        }

        contactAdapter.notifyDataSetChanged()
    }

    private fun observer() {
        vidalResumeViewModel.apply {
            toolMutable.observe(this@VidalResumeFragment, Observer {
                toolList.clear()
                toolList.addAll(it)

                toolAdapter.notifyDataSetChanged()
            })

            contactMutable.observe(this@VidalResumeFragment, Observer {
                contactList.clear()
                contactList.addAll(it)

                contactAdapter.notifyDataSetChanged()
            })
        }
    }
}