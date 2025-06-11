package com.thunderbolt.methods.bodhisattva.can.show


import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity

class FfzeAc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "showAd: 0", )

        onBackPressedDispatcher.addCallback {}
    }

    override fun onDestroy() {
        (window.decorView as? ViewGroup)?.removeAllViews()
        super.onDestroy()
    }
}
