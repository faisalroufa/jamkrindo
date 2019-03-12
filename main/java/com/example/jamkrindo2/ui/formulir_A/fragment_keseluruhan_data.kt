package com.example.jamkrindo2.ui.formulir_A


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jamkrindo2.R
import com.example.jamkrindo2.ui.formulir_A.subFragmentKeseluruhanData.*
import com.example.jamkrindo2.util.SharedModel


class fragment_keseluruhan_data : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_keseluruhan_data, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            val sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
            val data_namaPerusahaan = view.findViewById<TextView>(R.id.dataNamaPerusahaan)
            val color = resources.getColor(R.color.colorPrimary)
            sharedViewModel.data_namaPerusahaan_terjamin.observe(this, Observer {
                it?.let {
                    data_namaPerusahaan.setText("Nama Perusahaan    : "+it)
                    data_namaPerusahaan.setTextColor(color)
                }
            })
            val data_alamatPerusahaan = view.findViewById<TextView>(R.id.dataAlamatPerusahaan)
            sharedViewModel.data_alamat_terjamin.observe(this, Observer {
                it?.let {
                    data_alamatPerusahaan.setText("Alamat Perusahaan    : "+it)
                }
            })
            //data provinsi
            val data_provinsi = view.findViewById<TextView>(R.id.dataProvinsi)
            sharedViewModel.data_Provinsi_terjamin.observe(this, Observer {
                it?.let {
                    data_provinsi.setText("Provinsi         : "+it)
                    println(it)
                }
            })
            val data_kota = view.findViewById<TextView>(R.id.dataKota)
            sharedViewModel.data_Kota_terjamin.observe(this, Observer {
                it?.let {
                    data_kota.setText("Kota              : "+it)
                }
            })
            val data_kecamatan = view.findViewById<TextView>(R.id.dataKecamatan)
            sharedViewModel.data_Kecamatan_terjamin.observe(this, Observer {
                it?.let {
                    data_kecamatan.setText("Kecamatan              : "+it)
                }
            })
            val data_kelurahan = view.findViewById<TextView>(R.id.dataKelurahan)
            sharedViewModel.data_Kelurahan_terjamin.observe(this, Observer {
                it?.let {
                    data_kelurahan.setText("Kelurahan              : "+it)
                }
            })
            val data_noTelepon = view.findViewById<TextView>(R.id.dataNoTelepon)
            sharedViewModel.data_noTelepon_terjamin.observe(this, Observer {
                it?.let {
                    data_noTelepon.setText("No Telepon              : "+it)
                }
            })
            val data_klasifikasi_perusahaan = view.findViewById<TextView>(R.id.dataKlasifikasiPerusahaan)
            sharedViewModel.data_klasifikasi_perusahaan_terjamin.observe(this, Observer {
                it?.let {
                    data_klasifikasi_perusahaan.setText("Klasifikasi Perusahaan              : "+it)
                }
            })

        }
        addFragment(ChildFragment_BOD(),R.id.frame_BODContainer)
        addFragment(ChildFragment_PenanggungJawab(),R.id.frame_dataPenanggunJawabProyek)
//        fragment.addFragment(ChildFragment_PIC(),R.id.frame_dataPIC)
        addFragment(ChildFragment_PIC(),R.id.frame_dataPIC)
        addFragment(ChildFragment_Wanprestasi(),R.id.frame_wanprestasi)
        addFragment(ChildFragment_hukum(),R.id.frame_hukum)
        addFragment(ChildFragment_PenerimaJaminan(),R.id.frame_penerimaJaminan)
    }
    private fun addFragment(Fragment :Fragment, container: Int){
        val fragment = childFragmentManager.beginTransaction()
        fragment.add(container,Fragment)
        fragment.commit()
    }


}
