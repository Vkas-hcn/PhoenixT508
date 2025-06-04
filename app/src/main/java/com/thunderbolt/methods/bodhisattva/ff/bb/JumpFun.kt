package com.thunderbolt.methods.bodhisattva.ff.bb

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.Keep
@Keep
object JumpFun {
    private var lastStartTime: Long = 0L

    @Keep
    fun cckjh(context: Context, eIntent: Intent){
        val now = System.currentTimeMillis()
        if (now - lastStartTime >= 1000) {
            try {
                Log.e("TAG", "onReceive: 2", )
                context.startActivity(eIntent)
                lastStartTime = now
            } catch (e: Exception) {
                Log.e("TAG", "onReceive: e=${e.message}", )
            }
        }
    }
}