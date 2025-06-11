package com.thunderbolt.methods.bodhisattva.workfun

import androidx.annotation.Keep
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.thunderbolt.methods.bodhisattva.ui.App
import java.util.concurrent.TimeUnit

@Keep
object WorkerManager {
    private const val PERIODIC_WORK_NAME = "canshowfun"


    @Keep
    fun enqueuePeriodicChain() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresBatteryNotLow(true)
            .build()

        val periodicWork = PeriodicWorkRequestBuilder<FirstWorker>(15, TimeUnit.MINUTES)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(App.instance).enqueueUniquePeriodicWork(
            PERIODIC_WORK_NAME,
            ExistingPeriodicWorkPolicy.REPLACE,
            periodicWork
        )
    }

    @Keep
    fun enqueueSelfLoop() {
        val work =
            OneTimeWorkRequestBuilder<LoopWorker>().setInitialDelay(2, TimeUnit.MINUTES).build()
        WorkManager.getInstance(App.instance).enqueue(work)
    }
}
