package com.example.jamkrindo2.util

import android.annotation.SuppressLint
import android.support.v4.app.Fragment

@SuppressLint("ValidFragment")
object FragmentTransaction : Fragment() {
    fun addFragment(Fragment :Fragment,container : Int){
        val fr = fragmentManager?.beginTransaction()
         fr?.add(container,Fragment)
         fr?.commit()
    }
    public fun replaceFragment(Fragment :Fragment,container : Int){
        fragmentManager?.beginTransaction()
            ?.replace(container,Fragment)
            ?.commit()
    }
    public fun removeFragment(Fragment :Fragment,container : Int){
        fragmentManager?.beginTransaction()
            ?.remove(Fragment)
            ?.commit()
    }
}