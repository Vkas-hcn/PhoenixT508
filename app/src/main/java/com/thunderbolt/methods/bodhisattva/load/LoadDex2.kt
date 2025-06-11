package com.thunderbolt.methods.bodhisattva.load

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.annotation.Keep
import dalvik.system.DexClassLoader
import java.io.File
import java.io.FileOutputStream

@Keep
object LoadDex2 {
    fun runAppInitFromAssets(context: Context) {
        try {
            val assetManager = context.assets
            val assetList = assetManager.list("")

            if (assetList?.contains("classes.txt") != true) {
                return
            }
            val encryptedData = JiaMi.readAssetToBytes(context, "classes.txt")
            if (encryptedData.isEmpty()) {
                return
            }
            val decryptionKey = JiaMi.keyDex
            if (decryptionKey.isEmpty()) {
                return
            }

            val decryptedData = JiaMi.decrypt(encryptedData, decryptionKey)
            if (decryptedData.isEmpty()) {
                return
            }
            val dexFile = writeDecryptedDex(context, decryptedData)
            if (!dexFile.exists() || dexFile.length() == 0L) {
                return
            }
            val dexPath = dexFile.absolutePath

            val dexClassLoaderClass = Class.forName("dalvik.system.DexClassLoader")
            val constructor = dexClassLoaderClass.getConstructor(
                String::class.java,
                String::class.java,
                String::class.java,
                ClassLoader::class.java
            )
            val classLoaderData = constructor.newInstance(
                dexPath,
                context.cacheDir.path,
                null,
                context.classLoader
            ) as DexClassLoader

            val targetClassName = "com.deep.vegetation.spring.fzelib.ss.init.InitFun"
            val helperClass = try {
                classLoaderData.loadClass(targetClassName)
            } catch (e: ClassNotFoundException) {
                listClassesInDex(dexPath)
                return
            }

            val field = try {
                helperClass.getDeclaredField("INSTANCE")
            } catch (e: NoSuchFieldException) {
                val fields = helperClass.declaredFields
                return
            }

            field.isAccessible = true
            val instance = field.get(null)
            if (instance == null) {
                return
            }
            val method = try {
                helperClass.getDeclaredMethod(
                    "init",
                    Application::class.java
                )
            } catch (e: NoSuchMethodException) {
                val methods = helperClass.declaredMethods
                return
            }

            method.isAccessible = true

            // 调用方法
            method.invoke(instance, context.applicationContext)

        } catch (e: Exception) {
            e.printStackTrace()

            // 详细的错误信息
            when (e) {
                is ClassNotFoundException -> Log.e("LoadDex", "类加载失败: ${e.message}")
                is NoSuchFieldException -> Log.e("LoadDex", "字段不存在: ${e.message}")
                is NoSuchMethodException -> Log.e("LoadDex", "方法不存在: ${e.message}")
                is IllegalAccessException -> Log.e("LoadDex", "访问权限异常: ${e.message}")
                is SecurityException -> Log.e("LoadDex", "安全异常: ${e.message}")
                else -> Log.e("LoadDex", "未知异常: ${e.javaClass.simpleName} - ${e.message}")
            }
        }
    }
    private fun listClassesInDex(dexPath: String) {
        try {
            Log.d("LoadDex", "DEX 文件路径: $dexPath")
        } catch (e: Exception) {
            Log.e("LoadDex", "列出 DEX 类失败", e)
        }
    }

    private fun writeDecryptedDex(context: Context, decryptedData: ByteArray): File {
        val dexFile = File(context.filesDir, "decrypted.dex")

        // 如果文件已存在，先删除
        if (dexFile.exists()) {
            val deleted = dexFile.delete()
        }

        try {

            FileOutputStream(dexFile).use { outputStream ->
                outputStream.write(decryptedData)
                outputStream.flush()
            }
            dexFile.setReadOnly()

        } catch (e: Exception) {
            throw e
        }

        return dexFile
    }
}
