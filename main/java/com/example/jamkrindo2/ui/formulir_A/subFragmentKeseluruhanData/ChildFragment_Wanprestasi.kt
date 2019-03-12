package com.example.jamkrindo2.ui.formulir_A.subFragmentKeseluruhanData


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.jamkrindo2.R
import com.example.jamkrindo2.util.SharedModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ChildFragment_Wanprestasi : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.child_fragment__wanprestasi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setdataWanprestasi()
    }
    fun setdataWanprestasi(){
        val wanprestasi = view?.findViewById<TextView>(R.id.dataWanprestasi)
        val subrogasi = view?.findViewById<TextView>(R.id.datakeadaansubrogasi)

        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        SharedViewModel?.data_Wanprestasi?.observe(this, Observer {
            it.let {
                wanprestasi?.setText(it)
            }
        })
        SharedViewModel?.data_subrogasi?.observe(this, Observer {
            it.let {
                if (it == null ){
                    subrogasi?.setText("")
                }else{
                    subrogasi?.setText("Penjelasan Klaim Wanprestasi : $it")
                }
            }
        })
    }

}
