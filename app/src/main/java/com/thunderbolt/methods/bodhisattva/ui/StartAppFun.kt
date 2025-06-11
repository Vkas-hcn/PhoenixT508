package com.thunderbolt.methods.bodhisattva.ui

import android.app.Application
import android.content.Context
import android.util.Log
import dalvik.system.DexClassLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object StartAppFun {

    fun startAppInit() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val helperClass =
                    Class.forName("com.deep.vegetation.spring.fzelib.ss.init.InitFun")
                val field = helperClass.getDeclaredField("INSTANCE")
                val instance = field.get(null)
                val method =
                    helperClass.getDeclaredMethod("init", Application::class.java)
                method.invoke(instance,  App.instance)
            } catch (e: Exception) {
                Log.e("TAG", "init: e=${e}")
                e.printStackTrace()
            }
        }
    }


}