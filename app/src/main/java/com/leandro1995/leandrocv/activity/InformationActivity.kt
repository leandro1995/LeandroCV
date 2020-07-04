package com.leandro1995.leandrocv.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.databinding.ActivityInformationBinding
import com.leandro1995.leandrocv.viewmodel.InformationViewModel

class InformationActivity : AppCompatActivity() {

    private lateinit var informationActivity: ActivityInformationBinding
    private lateinit var informationViewModel: InformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        informationViewModel = ViewModelProvider(this).get(InformationViewModel::class.java)

        observer()

        informationActivity = DataBindingUtil.setContentView(this, R.layout.activity_information)
        informationActivity.informationModel = informationViewModel

        view()
    }

    private fun view() {
        //informationViewModel.vidalResumeSelect()
        informationViewModel.articleSelect()
    }

    private fun observer() {
        informationViewModel.apply {
            shareSheetMutable.observe(this@InformationActivity, Observer {
                startActivity(Intent.createChooser(Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, it)
                    type = "text/plain"
                }, null))
            })

            fragmentSelectMutable.observe(this@InformationActivity, Observer {
                supportFragmentManager.beginTransaction().replace(R.id.contentLinear, it).commit()
            })
        }
    }
}