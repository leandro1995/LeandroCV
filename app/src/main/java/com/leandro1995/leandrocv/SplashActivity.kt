package com.leandro1995.leandrocv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandro1995.leandrocv.activity.TermAndConditionActivity
import com.leandro1995.leandrocv.config.Setting
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        GlobalScope.launch(Dispatchers.Main) {
            delay(TimeUnit.SECONDS.toMillis(Setting.SPLASH_TIME))

            startActivity(Intent(this@SplashActivity, TermAndConditionActivity::class.java))
            finish()
        }
    }
}