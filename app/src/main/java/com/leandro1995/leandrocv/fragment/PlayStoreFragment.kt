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
import com.leandro1995.leandrocv.adapter.PlayStoreAdapter
import com.leandro1995.leandrocv.databinding.FragmentPlayStoreBinding
import com.leandro1995.leandrocv.model.PlayStore
import com.leandro1995.leandrocv.viewmodel.PlayStoreViewModel

class PlayStoreFragment : Fragment() {

    private lateinit var playStoreBinding: FragmentPlayStoreBinding
    private lateinit var playStoreViewModel: PlayStoreViewModel

    private lateinit var playStoreAdapter: PlayStoreAdapter
    private lateinit var playStoreLinearLayoutManager: LinearLayoutManager

    private val playStoreList = mutableListOf<PlayStore>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return view(inflater = inflater, container = container)
    }

    private fun view(inflater: LayoutInflater, container: ViewGroup?): View {
        playStoreViewModel = ViewModelProvider(this).get(PlayStoreViewModel::class.java)

        observer()

        playStoreBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_play_store, container, false)
        playStoreBinding.playStoreModel = playStoreViewModel

        created()

        return playStoreBinding.root
    }

    private fun created() {
        playStoreViewModel.playStoreInit()

        playStoreAdapter =
            PlayStoreAdapter(activity = this.activity!!, playStoreList = playStoreList)

        playStoreLinearLayoutManager = LinearLayoutManager(activity)
        playStoreLinearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        playStoreBinding.playStoreRecycler.apply {
            adapter = playStoreAdapter
            layoutManager = playStoreLinearLayoutManager
        }

        playStoreAdapter.notifyDataSetChanged()
    }

    private fun observer() {
        playStoreViewModel.apply {
            playStoreMutable.observe(this@PlayStoreFragment, Observer {
                playStoreList.clear()
                playStoreList.addAll(it)

                playStoreAdapter.notifyDataSetChanged()
            })
        }
    }
}