package com.thunderbolt.methods.bodhisattva.ui.guide

import android.content.Intent
import android.util.Log
import androidx.activity.addCallback
import androidx.lifecycle.lifecycleScope
import com.thunderbolt.methods.bodhisattva.R
import com.thunderbolt.methods.bodhisattva.base.BaseActivity
import com.thunderbolt.methods.bodhisattva.base.BaseViewModel
import com.thunderbolt.methods.bodhisattva.databinding.ActivityGuideBinding
import com.thunderbolt.methods.bodhisattva.ui.MainActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout

class Guide2Activity : BaseActivity<ActivityGuideBinding, BaseViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_guide
    override val viewModelClass: Class<BaseViewModel>
        get() = BaseViewModel::class.java
    var job: Job? = null
    override fun setupViews() {
        onBackPressedDispatcher.addCallback {
        }
        lifecycleScope.launch {
            try {
                withTimeout(3000) {
                    while (isActive) {
                        delay(1000)
                    }
                }
            } catch (e: TimeoutCancellationException) {
                jumpMain()
            }
        }

    }

    fun jumpMain() {
        Log.e("TAG", "jumpMain: ", )
        startActivity(Intent(this@Guide2Activity, MainActivity::class.java))
        finish()
    }


    override fun observeViewModel() {
    }

}