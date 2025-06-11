package com.thunderbolt.methods.bodhisattva.load

import android.content.Context
import java.io.ByteArrayOutputStream
import java.io.FileOutputStream
import java.io.IOException
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec


object JiaMi {
    var keyDex = "0523456341291678"

    @Throws(IOException::class)
     fun readAssetToBytes(context: Context, assetName: String): ByteArray {
        context.assets.open(assetName).use { `is` ->
            val buffer = ByteArrayOutputStream()
            val data = ByteArray(16384)
            var nRead: Int
            while ((`is`.read(data).also { nRead = it }) != -1) {
                buffer.write(data, 0, nRead)
            }
            return buffer.toByteArray()
        }
    }

    @Throws(java.lang.Exception::class)
    fun encrypt(data: ByteArray, key: String): ByteArray {
        val secretKey = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        return cipher.doFinal(data)
    }

    // 将加密后的数据写入文件
    @Throws(IOException::class)
    fun writeFile(data: ByteArray?, filePath: String?) {
        val fos = FileOutputStream(filePath)
        fos.write(data)
        fos.close()
    }
    fun generateEncryptedPng(context: Context) {
        try {
            val soBytes = readAssetToBytes(context, "classes.dex")
            // 对文件内容进行AES加密
            val encryptedData: ByteArray = encrypt(soBytes, keyDex)
            // 将加密后的内容保存为新文件
            val fileName = context.dataDir.toString() + "/classes.txt"
            writeFile(encryptedData, fileName)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    // AES解密
    @Throws(Exception::class)
    fun decrypt(encryptedData: ByteArray?, key: String): ByteArray {
        val secretKey = SecretKeySpec(key.toByteArray(), "AES")
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        return cipher.doFinal(encryptedData)
    }

}
