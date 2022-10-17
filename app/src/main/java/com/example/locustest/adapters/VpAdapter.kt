package com.example.locustest.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.locustest.fragments.FragmentCall
import com.example.locustest.fragments.FragmentChat
import com.example.locustest.fragments.FragmentStatus

class VpAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
      return  when(position){
            0->{
                FragmentChat()
            }
            1->{
                FragmentCall()
            }
            2->{
                FragmentStatus()

            }
            else->{
                Fragment()
            }
        }
    }
}