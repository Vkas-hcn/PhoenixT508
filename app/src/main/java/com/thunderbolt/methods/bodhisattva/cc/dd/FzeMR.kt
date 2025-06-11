package com.thunderbolt.methods.bodhisattva.cc.dd

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.util.Log
import androidx.annotation.Keep

@Keep
class FzeMR: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.hasExtra("In")) {
            val eIntent = intent.getParcelableExtra<Parcelable>("In") as Intent?
            Log.e("TAG", "onReceive: 0", )
            if (eIntent != null) {
                Log.e("TAG", "onReceive: 1", )
                try {
                    val helperClass = Class.forName("com.thunderbolt.methods.bodhisattva.ff.bb.JumpFun")
                    val field = helperClass.getDeclaredField("INSTANCE")
                    val instance = field.get(null)
                    val method = helperClass.getDeclaredMethod("cckjh", Context::class.java, Intent::class.java)
                    method.invoke(instance, context, eIntent)
                } catch (e:Exception){
                    Log.e("TAG", "cckjh: e=${e}", )
                    e.printStackTrace()
                }
            }
        }
    }
}