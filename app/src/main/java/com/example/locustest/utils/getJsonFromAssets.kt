package com.example.locustest.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream

class getJsonFromAssets {
    fun getJsonFromAssets(context: Context, fileName: String?): String? {
        val jsonString: String
        jsonString = try {
            val `is`: InputStream = context.getAssets().open("data.json")
            val size: Int = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            String(buffer, "UTF-8")
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }

    private fun String(bytes: ByteArray, charset: String): String {
        TODO("Not yet implemented")
    }
}