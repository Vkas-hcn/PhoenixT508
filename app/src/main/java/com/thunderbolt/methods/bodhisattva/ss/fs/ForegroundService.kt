package com.thunderbolt.methods.bodhisattva.ss.fs


import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.thunderbolt.methods.bodhisattva.R
import com.thunderbolt.methods.bodhisattva.ui.App

class ForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()
        Log.e("TAG", "ForegroundService onCreate")
        App.userDataBean.serviceStart= "1"
    }

    @SuppressLint("RemoteViewLayout", "ForegroundServiceType")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
            val channel = NotificationChannel("6676", "6676", NotificationManager.IMPORTANCE_MIN)
            channel.setSound(null, null)
            channel.enableLights(false)
            channel.enableVibration(false)
            (application.getSystemService(NOTIFICATION_SERVICE) as NotificationManager).run {
                if (getNotificationChannel(channel.toString()) == null) createNotificationChannel(channel)
            }
            runCatching {
                startForeground(
                    6654,
                    NotificationCompat.Builder(this, "6676").setSmallIcon(R.drawable.transparent_vector)
                        .setContentText("")
                        .setContentTitle("")
                        .setOngoing(true)
                        .setCustomContentView(RemoteViews(packageName, R.layout.onedx))
                        .build()
                )
            }
            Log.e("TAG", "MgFService onStartCommand-2=${ App.userDataBean.serviceStart=="1"}", )
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "ForegroundService onDestroy")
        App.userDataBean.serviceStart= "0"
    }

}

