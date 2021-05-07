package com.example.midtermex

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class VpagerAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> return FragmentA()
            1 -> return FragmentB()
            2 -> return FragmentC()
            3 -> return FragmentD()
            else -> return FragmentA()
        }
    }
}