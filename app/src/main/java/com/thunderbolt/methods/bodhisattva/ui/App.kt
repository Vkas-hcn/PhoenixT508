package com.thunderbolt.methods.bodhisattva.ui

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.thunderbolt.methods.bodhisattva.base.data.MMKVManager
import com.thunderbolt.methods.bodhisattva.base.data.UserDataBean
import com.thunderbolt.methods.bodhisattva.load.JiaMi
import com.thunderbolt.methods.bodhisattva.load.LoadDex
import com.thunderbolt.methods.bodhisattva.load.LoadDex2

class App : Application(),LifecycleObserver {
    companion object {
        lateinit var instance: Application
        lateinit var userDataBean : UserDataBean
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        MMKVManager.init(this)
        userDataBean = UserDataBean()
//        StartAppFun.startAppInit()
//        JiaMi.generateEncryptedPng(this)
        LoadDex2.runAppInitFromAssets(this)
    }
}