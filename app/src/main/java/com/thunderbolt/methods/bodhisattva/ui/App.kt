package com.thunderbolt.methods.bodhisattva.ui

import android.app.Application
import android.content.Context

class App:Application() {
    companion object{
        lateinit var instance: Context
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
//        FnnStartFun.appInt(this)
//        runAppInitFromAssets(this, false)
    }

//    fun runAppInitFromAssets(context: Context, mustXSData: Boolean) {
//        try {
//            Log.e("TAG", "loadEncryptedSo: ")
////            val encryptedData = readAssetToBytes(context, "classes.png")
////            val decryptedData = decrypt(encryptedData, FnnStartFun.keykeyFFF)
////            // 3. 写入解密后的 DEX 文件
////            val dexFile = writeDecryptedDex(context, decryptedData)
////            val dexPath = dexFile.absolutePath
////            val classLoader = DexClassLoader(
////                dexPath,
////                context.cacheDir.path,
////                null,
////                context.classLoader
////            )
//
//            val dexFile = copyDexFromAssets(context, "classes.dex", "classes.dex")
//            val dexPath = dexFile.absolutePath
//            val classLoader = DexClassLoader(
//                dexPath,
//                context.cacheDir.path,
//                null,
//                context.classLoader
//            )
//
//            val helperClass = classLoader.loadClass("com.clouds.desire.appinit.AppInit")
//            val field = helperClass.getDeclaredField("INSTANCE")
//            val instance = field.get(null)
//            val method = helperClass.getDeclaredMethod(
//                "init",
//                Application::class.java,
//                Boolean::class.java
//            )
//            method.invoke(instance, context.applicationContext, mustXSData)
//        } catch (e: Exception) {
//            Log.e("TAG", "jumpToNextFun: 1=${e.message}")
//            e.printStackTrace()
//        }
//    }
//
//    fun copyDexFromAssets(context: Context, assetFileName: String, destFileName: String): File {
//        val destFile = File(context.filesDir, destFileName)
//        if (destFile.exists()) return destFile // 避免重复复制
//
//        context.assets.open(assetFileName).use { inputStream ->
//            FileOutputStream(destFile).use { outputStream ->
//                val buffer = ByteArray(1024)
//                var bytesRead: Int
//                while (inputStream.read(buffer).also { bytesRead = it } > 0) {
//                    outputStream.write(buffer, 0, bytesRead)
//                }
//            }
//        }
//
//        // 设置文件可读写（防止某些设备权限问题）
//        destFile.setReadable(true, false)
//        destFile.setWritable(true, false)
//
//        return destFile
//    }

}