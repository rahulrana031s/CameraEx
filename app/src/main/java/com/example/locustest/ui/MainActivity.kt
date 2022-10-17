package com.example.locustest.ui

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.locustest.R
import com.example.locustest.adapters.MUltiViewAdapter
import com.example.locustest.databinding.ActivityMainBinding
import com.example.locustest.modal.LocusDataModal
import com.example.locustest.modal.LocusDataModalItem
import com.example.locustest.utils.Utils
import com.example.locustest.viewmodal.MainActivityViewModal
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity(), MUltiViewAdapter.OnItemClickListener {

    val TAG = "MainActivity"
    private var mainActivityViewModal: MainActivityViewModal? = null
    lateinit var binding: ActivityMainBinding
    private var mUltiViewAdapter: MUltiViewAdapter? = null
    private var locusDataModalItem: LocusDataModal? = null
    private var dataSend: ArrayList<LocusDataModalItem>? = null

    var imgUri : Uri? = null
    var pos = 0
    var category = ""

    private  val contract = registerForActivityResult(ActivityResultContracts.TakePicture()){
        if(category == "PHOTO"){
            dataSend?.get(pos)?.uri = imgUri.toString()
            mUltiViewAdapter?.notifyDataSetChanged()
            category=""
            pos=0
            imgUri = null

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        setViewModal()
        setAdapter()
        setupObserver()


    }

    private fun setupObserver() {
        mainActivityViewModal!!.getUsers().observe(this, Observer {
            it?.let { data -> renderList(data) }

        })

    }

    private fun renderList(data: ArrayList<LocusDataModalItem>) {
        Log.e("val is",data.toString())
        dataSend = data
        binding.rlvItem.layoutManager =  LinearLayoutManager(this)


        mUltiViewAdapter = MUltiViewAdapter(this,this, dataSend!!)
        binding.rlvItem.adapter = mUltiViewAdapter
    }

    private fun setAdapter() {

    }

    private fun setViewModal() {
        mainActivityViewModal = ViewModelProvider(this)
            .get("Main activity", MainActivityViewModal::class.java)

//        observeResponse()/**/

    }

    override fun onItemClick(type: String, position: Int) {
        pos = position
        category = type
        imgUri = Utils.createImageuri(applicationContext,type)
        if(type == "Remove"){
            dataSend!![position]?.uri = ""
            mUltiViewAdapter?.notifyDataSetChanged()
        }else{
            if(type == "PHOTO"){
                if(TextUtils.isEmpty(dataSend!![position]?.uri)){
                    contract.launch(imgUri)
                }else{
                    openImageInFullScreen()
                }

            }
        }

    }

    private fun openImageInFullScreen() {
        val dialog = Dialog(this)
        Objects.requireNonNull(dialog.window)!!
            .setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.full_image_item)
        val img_full: ImageView = dialog.findViewById(R.id.img_full)
        img_full.setImageURI(Uri.parse(dataSend?.get(pos)!!.uri))
        val imgClose: ImageView = dialog.findViewById(R.id.img_close)


        imgClose.setOnClickListener { // Close dialog
            dialog.dismiss()
        }
        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //adding menu button
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.mybutton) {
            //
            logData();
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logData() {
        for (ids in dataSend!!) {
            println(ids.id)
        }

    }

}



