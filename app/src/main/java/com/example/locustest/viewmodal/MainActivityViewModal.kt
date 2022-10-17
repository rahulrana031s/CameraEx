package com.example.locustest.viewmodal

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.locustest.utils.Utils
import com.example.locustest.modal.LocusDataModalItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivityViewModal(val context: Application): AndroidViewModel(context) {

    private var dataGet = MutableLiveData<ArrayList<LocusDataModalItem>>()
    private var dataGet1 = ArrayList<LocusDataModalItem>()

    init {
        getJsonFromAssets()
    }


    fun getJsonFromAssets() {
        val jsonFileString = Utils.getJsonFromAssets(context, "data.json")
        Log.e("file is", jsonFileString.toString())
        val gson = Gson()
        val listUserType: Type = object : TypeToken<ArrayList<LocusDataModalItem?>?>() {}.type
        dataGet1 =
            gson.fromJson<ArrayList<LocusDataModalItem>>(jsonFileString, listUserType)
        dataGet.value = dataGet1

    }

    fun getUsers(): MutableLiveData<ArrayList<LocusDataModalItem>> {
        return dataGet
    }

}
