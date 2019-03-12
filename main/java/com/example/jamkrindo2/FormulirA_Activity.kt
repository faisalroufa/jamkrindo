package com.example.jamkrindo2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.example.jamkrindo2.ui.childFragment.biodata_penanggungJawab
import kotlinx.android.synthetic.main.exit_alert_dalog.view.*
import kotlinx.android.synthetic.main.form_satu_main.*
import com.example.jamkrindo2.ui.formulir_A.*


class FormulirA_Activity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_satu_main)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(form1_fragment_dataPerusahaan(), "Data Perusahaan")
        adapter.addFragment(form1_fragment_dua(), "Data BOD")
        adapter.addFragment(biodata_penanggungJawab(), "Data Penanggung Jawab Proyek")
        adapter.addFragment(form1_fragment_PIC(), "Data PIC")
        adapter.addFragment(form1_fragment_wanprestasi(), "Data Wanprestasi")
        adapter.addFragment(form1_fragment_hukum(), "Data Kasus Hukum")
        adapter.addFragment(form1_fragment_penerimaJaminan(), "Data Penerima Jaminan")
        adapter.addFragment(fragment_keseluruhan_data(), "Data Keseluruhan")


        viewPager.pageMargin = 50
        viewPager.clipToPadding = false
        viewPager.setPadding(20,0,20,0)
        viewPager.adapter   =   adapter
        tabs.setupWithViewPager(viewPager)
//        formA_navbar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                println("page"+p0)
            }
        })
    }


    override fun onCreateView(name: String?, context: Context?, attrs: AttributeSet?): View? {
        return super.onCreateView(name, context, attrs)

    }
    class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
         val fragmentList : MutableList<Fragment> = ArrayList()
         val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }
        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
            notifyDataSetChanged()
        }
        override fun getPageTitle(position: Int): CharSequence?{
            return titleList[position]
        }
    }

    override fun onBackPressed() {
        val alertView = LayoutInflater.from(this).inflate(R.layout.exit_alert_dalog,null)
        val mBuilder = AlertDialog.Builder(this)
            .setView(alertView)
            .setTitle("Exit Alert")
        //show dialog
        val  alertDialog = mBuilder.show()

        alertView.bt_ya.setOnClickListener {
            val intent  =   Intent (this, MainActivity::class.java)
            startActivity(intent)
            finish()
            alertDialog.dismiss()

        }
        alertView.bt_tidak.setOnClickListener {
            alertDialog.dismiss()
        }
    }
}