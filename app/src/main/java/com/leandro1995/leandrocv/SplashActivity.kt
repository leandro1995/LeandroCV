package com.leandro1995.leandrocv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.leandro1995.leandrocv.config.Setting
import com.leandro1995.leandrocv.databinding.ActivitySplashBinding
import com.leandro1995.leandrocv.viewmodel.SplashViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding
    private lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        observer()

        splashBinding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        splashBinding.splashModel = splashViewModel

        view()
    }

    private fun view() {
        GlobalScope.launch(Dispatchers.Main) {
            delay(TimeUnit.SECONDS.toMillis(Setting.SPLASH_TIME))

            splashViewModel.splashTimeOut()
        }
    }

    private fun observer() {
        splashViewModel.apply {
            termAndConditionMutable.observe(this@SplashActivity, Observer {
                startActivity(Intent(this@SplashActivity, it))
                finish()
            })

            informationMutable.observe(this@SplashActivity, Observer {
                startActivity(Intent(this@SplashActivity, it))
                finish()
            })
        }
    }
}