package com.example.jamkrindo2.ui.main


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jamkrindo2.FormulirA_Activity

import com.example.jamkrindo2.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val BT_penawaran    =   view.findViewById<CardView>(R.id.penawaran)
        val BT_uangMuka    =   view.findViewById<CardView>(R.id.uangMuka)
        val BT_pembayaran    =   view.findViewById<CardView>(R.id.pembayaran)
        val BT_pelaksanaan    =   view.findViewById<CardView>(R.id.pelaksanaan)
        val BT_pemeliharaan    =   view.findViewById<CardView>(R.id.pemeliharaan)



        BT_penawaran.setOnClickListener {
            
            val intent = Intent(context, FormulirA_Activity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        BT_uangMuka.setOnClickListener {

            val intent = Intent(context, FormulirA_Activity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        BT_pembayaran.setOnClickListener {

            val intent = Intent(context, FormulirA_Activity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        BT_pelaksanaan.setOnClickListener {

            val intent = Intent(context, FormulirA_Activity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        BT_pemeliharaan.setOnClickListener {

            val intent = Intent(context, FormulirA_Activity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
}
