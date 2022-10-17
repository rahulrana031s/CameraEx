package com.example.locustest.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.locustest.R
import com.example.locustest.adapters.VpAdapter
import com.example.locustest.databinding.ActivityMainBinding
import com.example.locustest.databinding.TabActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabActivity : AppCompatActivity() {

    lateinit var binding: TabActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.tab_activity)
        binding.lifecycleOwner = this
        setAdapter()


    }

    private fun setAdapter() {
        val adapter = VpAdapter(supportFragmentManager,lifecycle)
        binding.vpMain.adapter=adapter

        TabLayoutMediator(binding.tabLayout,binding.vpMain){
            tab,position->
                when(position){
                    0->{
                        tab.text = "chat"
                    }
                    1->{
                        tab.text = "call"
                    }
                    2->{
                        tab.text = "status"
                    }
                }

        }.attach()
    }
}
