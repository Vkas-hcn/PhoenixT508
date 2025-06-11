package com.thunderbolt.methods.bodhisattva.ff.bb

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.annotation.Keep
import androidx.core.content.ContextCompat
import com.thunderbolt.methods.bodhisattva.ss.fs.ForegroundService

@Keep
object SSFan {
    @Keep
    fun startForegroundService(context: Context) {
        try {
            Log.e("TAG", "startForegroundService: 1", )
            ContextCompat.startForegroundService(
                context,
                Intent(context, ForegroundService::class.java)
            )
        } catch (e: Exception) {
            Log.e("TAG","Error starting startForegroundService: ${e.message}")
            e.printStackTrace()
        }
    }

}