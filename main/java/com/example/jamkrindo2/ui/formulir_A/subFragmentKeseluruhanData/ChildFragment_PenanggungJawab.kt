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
class ChildFragment_PenanggungJawab : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child_fragment__penanggung_jawab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setTextDataPenangungJawab()
    }

    private fun setTextDataPenangungJawab(){
        activity?.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        val data_namaPenanggungJawab = view?.findViewById<TextView>(R.id.dataNamaPenangungJawab)
        val data_NIKPenanggungJawab = view?.findViewById<TextView>(R.id.dataNIKPenanggungJawab)
        val data_noTelpPenanggungJawab = view?.findViewById<TextView>(R.id.dataNoTelpPenangungJawab)
        val data_emailPenanggungJawab = view?.findViewById<TextView>(R.id.dataEmailPenangungJawab)
        val data_jabatanPenanggungJawab = view?.findViewById<TextView>(R.id.dataJabatanPenangungJawab)

        SharedViewModel?.data_nama_penanggungJawabProyek?.observe(this, Observer {
            it.let {
                data_namaPenanggungJawab?.setText("Nama     : $it")
                println(it)
            }
        })
        SharedViewModel?.data_nama_penanggungJawabProyek?.removeObservers(requireActivity())
        SharedViewModel?.data_NIK_penanggungJawabProyek?.observe(this, Observer {
            it.let {
                data_NIKPenanggungJawab?.setText("NIK     : $it")

            }
        })
        SharedViewModel?.data_noTelp_penanggungJawabProyek?.observe(this, Observer {
            it.let {
                data_noTelpPenanggungJawab?.setText("No Telepon     : $it")
            }
        })
        SharedViewModel?.data_email_penanggungJawabProyek?.observe(this, Observer {
            it.let {
                data_emailPenanggungJawab?.setText("Email     : $it")
            }
        })
        SharedViewModel?.data_jabatan_penanggungJawabProyek?.observe(this, Observer {
            it.let {
                data_jabatanPenanggungJawab?.setText("Jabatan     : $it")

            }
        })

    }


}
