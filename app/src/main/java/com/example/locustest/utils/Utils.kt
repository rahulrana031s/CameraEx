package com.example.locustest.utils

import android.content.Context
import android.net.Uri
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

object Utils {

    fun getJsonFromAssets(context: Context, fileName: String?): String? {
        val jsonString: String
        val charset: Charset = Charsets.UTF_8

        jsonString = try {
            val `is`: InputStream = context.assets.open(fileName!!)
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, charset)

        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }

    fun createImageuri(context: Context,name:String):Uri?{
        val image = File(context.filesDir,name)
        return FileProvider.getUriForFile(context,
            "com.example.locustest.fileProvider",image)
    }
}