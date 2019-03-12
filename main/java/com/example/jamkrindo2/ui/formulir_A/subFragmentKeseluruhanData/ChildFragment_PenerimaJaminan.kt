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
class ChildFragment_PenerimaJaminan : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_child_fragment_penerima_jaminan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataPenerimaJaminan()
    }

    fun setDataPenerimaJaminan(){
        val namaPerusahaan = view?.findViewById<TextView>(R.id.dataNamaPenerimaJaminan)
        val alamatPerusahaan = view?.findViewById<TextView>(R.id.dataAlamatPenerimaJaminan)
        val dataProvinsi = view?.findViewById<TextView>(R.id.dataProvinsiPenerimaJaminan)
        val dataKota = view?.findViewById<TextView>(R.id.dataKotaPenerimaJaminan)
        val dataKecamatan = view?.findViewById<TextView>(R.id.dataKecamatanPenerimaJaminan)
        val dataKelurahan = view?.findViewById<TextView>(R.id.dataKelurahanPenerimaJaminan)
        val dataBentukHukum = view?.findViewById<TextView>(R.id.dataBadanHukumPenerimaJaminan)
        val dataStatusHukum = view?.findViewById<TextView>(R.id.dataStatusBadanHukumPenerimaJaminan)

        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        SharedViewModel?.data_namaPerusahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                namaPerusahaan?.setText("Nama : $it")
            }
        })
        SharedViewModel?.data_alamatPerusahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                alamatPerusahaan?.setText("Alamat : $it")
            }
        })
        SharedViewModel?.data_provinsiPerusahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                dataProvinsi?.setText("Provinsi : $it")
            }
        })
        SharedViewModel?.data_kotaPersahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                dataKota?.setText("Kota : $it")
            }
        })
        SharedViewModel?.data_kecamtanPerusahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                dataKecamatan?.setText("Kecamatan : $it")
            }
        })
        SharedViewModel?.data_kelurahanPerusahaanPenerimaJaminan?.observe(this, Observer {
            it.let {
                dataKelurahan?.setText("Kelurahan : $it")
            }
        })
        SharedViewModel?.data_bentukBadanHukum?.observe(this, Observer {
            it.let {
                dataBentukHukum?.setText("Bentuk Hukum : $it")
            }
        })
        SharedViewModel?.data_statusBadanHukum?.observe(this, Observer {
            it.let {
                dataStatusHukum?.setText("Status Bentuk Hukum : $it")
            }
        })


    }

}
