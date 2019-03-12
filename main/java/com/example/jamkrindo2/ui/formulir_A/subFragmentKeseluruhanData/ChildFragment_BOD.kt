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


/**
 * A simple [Fragment] subclass.
 *
 */
class ChildFragment_BOD : Fragment() {
    private var sharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.child_fragment_biodata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    setText()
    }
    fun setText(){
        activity?.let {
            sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        val namaBOD = view?.findViewById<TextView>(R.id.dataNama)
        val NIKBOD = view?.findViewById<TextView>(R.id.dataNIK)
        val noTelBOD = view?.findViewById<TextView>(R.id.dataNoTelp)
        val emailBOD = view?.findViewById<TextView>(R.id.dataEmail)
        val jabatanBOD = view?.findViewById<TextView>(R.id.dataJabatan)

        sharedViewModel?.data_nama_BOD?.observe(this, Observer {
            it.let {
                namaBOD?.setText("Nama  : $it")
            }
        })
        sharedViewModel?.data_NIK_BOD?.observe(this, Observer {
            it.let {
                NIKBOD?.setText("NIK  : $it")
            }
        })
        sharedViewModel?.data_NoTelp_BOD?.observe(this, Observer {
            it.let {
                noTelBOD?.setText("No Telepon  : $it")
            }
        })
        sharedViewModel?.data_Email_BOD?.observe(this, Observer {
            it.let {
                emailBOD?.setText("Email  : $it")
            }
        })
        sharedViewModel?.data_Jabatan_BOD?.observe(this, Observer {
            it.let {
                jabatanBOD?.setText("Jabatan  : "+it)
            }
        })
    }


}
