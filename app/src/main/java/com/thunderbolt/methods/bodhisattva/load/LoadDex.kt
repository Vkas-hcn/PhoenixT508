package com.thunderbolt.methods.bodhisattva.load

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import dalvik.system.DexClassLoader
import java.io.File
import java.io.FileOutputStream
import java.util.Objects

@Keep
object LoadDex {
    fun runAppInitFromAssets(context: Context) {
        try {
            Log.e("TAG", "runAppInitFromAssets: ")

            val dexClassLoaderClass = Class.forName("dalvik.system.DexClassLoader")
            val constructor = dexClassLoaderClass.getConstructor(
                String::class.java,
                String::class.java,
                String::class.java,
                ClassLoader::class.java
            )


//            val encryptedData = JiaMi.readAssetToBytes(context, "classes.txt")
//            val decryptedData = JiaMi.decrypt(encryptedData, JiaMi.keyDex)
//            // 3. 写入解密后的 DEX 文件
//            val dexFile = writeDecryptedDex(context, decryptedData)
//            val dexPath = dexFile.absolutePath


            val dexFile = copyDexFromAssets(context, "classes.dex", "classes.dex")
            dexFile.setReadOnly()

            val dexPath = dexFile.absolutePath
            val classLoaderData = constructor.newInstance(
                dexPath,
                context.cacheDir.path,
                null,
                context.classLoader
            ) as DexClassLoader

//            val classLoaderData = DexClassLoader(
//                dexPath,
//                context.cacheDir.path,
//                null,
//                context.classLoader
//            )

            val helperClass =
                classLoaderData.loadClass("com.deep.vegetation.spring.fzelib.ss.InitFun")
            val field = helperClass.getDeclaredField("INSTANCE")
            val instance = field.get(null)
            val method = helperClass.getDeclaredMethod(
                "init",
                Application::class.java
            )
            method.invoke(instance, context.applicationContext)


//            val helperClass2 =
//                classLoaderData.loadClass("com.deep.vegetation.spring.fzelib.ss.SoDirectoryFun")
//            val field2 = helperClass2.getDeclaredField("INSTANCE")
//            val instance2 = field2.get(null)
//            val method2 = helperClass2.getDeclaredMethod("createDirectory", Context::class.java)
//            method2.invoke(instance2, context)
        } catch (e: Exception) {
            Log.e("TAG", "runAppInitFromAssets: 1=${e.message}")
            e.printStackTrace()
        }

        try {

        } catch (e: Exception) {
            Log.e("TAG", "huolaFun: e=${e}")
            e.printStackTrace()
        }
    }

    fun copyDexFromAssets(context: Context, assetFileName: String, destFileName: String): File {
        val destFile = File(context.filesDir, destFileName)
        if (destFile.exists()) return destFile // 避免重复复制

        context.assets.open(assetFileName).use { inputStream ->
            FileOutputStream(destFile).use { outputStream ->
                val buffer = ByteArray(1024)
                var bytesRead: Int
                while (inputStream.read(buffer).also { bytesRead = it } > 0) {
                    outputStream.write(buffer, 0, bytesRead)
                }
            }
        }

        // 设置文件可读写（防止某些设备权限问题）
//        destFile.setReadable(true, false)
//        destFile.setWritable(true, false)

        return destFile
    }

    private fun writeDecryptedDex(context: Context, decryptedData: ByteArray): File {
        val dexFile = File(context.filesDir, "decrypted.dex")

        if (dexFile.exists()) {
            dexFile.delete() // 如果已存在旧文件则删除
        }
        dexFile.createNewFile()

        // 写入解密后的 DEX 数据
        FileOutputStream(dexFile).use { outputStream ->
            outputStream.write(decryptedData)
        }
        // 设置文件权限为可读写
        dexFile.setReadable(true, false)
        dexFile.setWritable(true, false)
        return dexFile
    }
}