package com.leandro1995.leandrocv.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.airbnb.paris.extensions.style
import com.leandro1995.leandrocv.R
import com.leandro1995.leandrocv.databinding.ActivityTermAndConditionBinding
import com.leandro1995.leandrocv.viewmodel.TermAndConditionViewModel
import kotlinx.android.synthetic.main.activity_term_and_condition.*

class TermAndConditionActivity : AppCompatActivity() {

    private lateinit var termAndConditionBinding: ActivityTermAndConditionBinding
    private lateinit var termAndConditionViewModel: TermAndConditionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        termAndConditionViewModel =
            ViewModelProvider(this).get(TermAndConditionViewModel::class.java)

        observer()

        termAndConditionBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_term_and_condition)

        termAndConditionBinding.termAndConditionModel = termAndConditionViewModel

        view()
    }

    private fun view() {
        termAndConditionBinding.termAndConditionCheck.setOnCheckedChangeListener { _, status ->
            termAndConditionViewModel.styleButton(status = status)
        }
    }

    private fun observer() {
        termAndConditionViewModel.apply {
            styleButtonMutable.observe(this@TermAndConditionActivity, Observer {
                acceptButton.style(it)
            })

            acceptMutable.observe(this@TermAndConditionActivity, Observer {
                startActivity(Intent(this@TermAndConditionActivity, it))
                finish()
            })
        }
    }
}