package com.thunderbolt.methods.bodhisattva.workfun

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class LoopWorker(context: Context, workerParams: WorkerParameters)
    : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.e("TAG", "LoopWorker 执行", )
        WorkerManager.enqueueSelfLoop()
        return Result.success()
    }
}
