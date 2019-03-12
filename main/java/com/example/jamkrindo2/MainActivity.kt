package com.example.jamkrindo2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.widget.FrameLayout
import com.example.jamkrindo2.ui.main.Akun
import com.example.jamkrindo2.ui.main.Home
import com.example.jamkrindo2.ui.main.Notifikasi
import kotlinx.android.synthetic.main.activity_main_material.*

class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_material)
        addfragment(Home())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home -> {
                addfragment(Home())
                return@OnNavigationItemSelectedListener true
            }
            R.id.akun -> {
                addfragment(Akun())
                return@OnNavigationItemSelectedListener true
            }
            R.id.notifikasi -> {
                addfragment(Notifikasi())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    private fun addfragment(fragment:Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_mainmenu,fragment,fragment.javaClass.simpleName)
            .commit()
    }

}
