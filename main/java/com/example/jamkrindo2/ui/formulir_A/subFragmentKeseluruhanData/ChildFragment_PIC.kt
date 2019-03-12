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
class ChildFragment_PIC : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.child_fragment__pic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    fun setData(){
        val data_namaBOD = view?.findViewById<TextView>(R.id.datanamaBOD)
        val data_namaPIC = view?.findViewById<TextView>(R.id.dataNamaPIC)
        val data_jabatanPIC = view?.findViewById<TextView>(R.id.dataJabatanPIC)
        val data_noTelpPIC = view?.findViewById<TextView>(R.id.dataNoTelpPIC)
        val data_NIKPIC = view?.findViewById<TextView>(R.id.dataNIKPIC)
        val data_emailPIC = view?.findViewById<TextView>(R.id.dataEmailPIC)
        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        SharedViewModel?.data_nama_BOD?.observe(this, Observer {
            it.let {
                data_namaBOD?.setText("Nama BOD : $it")

            }
        })
        SharedViewModel?.data_nama_PIC?.observe(this, Observer {
            it.let {
                data_namaPIC?.setText("Nama PIC : $it")

            }
        })
        SharedViewModel?.data_jabatan_PIC?.observe(this, Observer {
            it.let {
                data_jabatanPIC?.setText("Jabatan : $it")

            }
        })
        SharedViewModel?.data_noTelp_PIC?.observe(this, Observer {
            it.let {
                data_noTelpPIC?.setText("No Telepon : $it")

            }
        })
        SharedViewModel?.data_NIK_PIC?.observe(this, Observer {
            it.let {
                data_NIKPIC?.setText("NIK : $it")

            }
        })
        SharedViewModel?.data_email_PIC?.observe(this, Observer {
            it.let {
                data_emailPIC?.setText("Email : $it")

            }
        })

    }


}
