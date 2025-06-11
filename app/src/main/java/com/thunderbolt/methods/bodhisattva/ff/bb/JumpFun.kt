package com.thunderbolt.methods.bodhisattva.ff.bb

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.Keep
import com.thunderbolt.methods.bodhisattva.ll.oo.FzeLo
import com.thunderbolt.methods.bodhisattva.workfun.WorkerManager

@Keep
object JumpFun {

    private val handler = Handler(Looper.getMainLooper())
    private var debounceRunnable: Runnable? = null

    @Keep
    fun cckjh(context: Context, eIntent: Intent) {
        debounceRunnable?.let { handler.removeCallbacks(it) }
        debounceRunnable = Runnable {
            try {
                Log.e("TAG", "onReceive: 2")
                context.startActivity(eIntent)
            } catch (e: Exception) {
                Log.e("TAG", "startActivity failed: ${e.message}")
            }
        }
        handler.postDelayed(debounceRunnable!!, 1000)
    }

    @Keep
    fun startSOFun(context: Context, num: Int) {
        Log.e("TAG", "startSOFun: ${num}")
        FzeLo.ffzoojk(context, num)
    }

    @Keep
    fun workFun() {
        WorkerManager.enqueuePeriodicChain()
        WorkerManager.enqueueSelfLoop()
    }
}