package com.example.jamkrindo2.util

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.jamkrindo2.data.dataProvinsi


class SharedModel: ViewModel(){


    val input_error_msg = MutableLiveData<String>()
    val data_provinsi = mutableListOf<dataProvinsi>()

    //input data Bio
    val input_nama = MutableLiveData<String>()
    val input_NIK = MutableLiveData<String>()
    val input_NoTelp = MutableLiveData<String>()
    val input_Email = MutableLiveData<String>()
    val input_Jabatan = MutableLiveData<String>()

    //input data alamat
    val input_alamat = MutableLiveData<String>()
    val input_Provinsi = MutableLiveData<String>()
    val input_Kota = MutableLiveData<String>()
    val input_Kecamatan = MutableLiveData<String>()
    val input_Kelurahan = MutableLiveData<String>()

    //data  perusahaan terjamin
    val data_alamat_terjamin = MutableLiveData<String>()
    val data_Provinsi_terjamin = MutableLiveData<String>()
    val data_Kota_terjamin = MutableLiveData<String>()
    val data_Kecamatan_terjamin = MutableLiveData<String>()
    val data_Kelurahan_terjamin = MutableLiveData<String>()
    val data_namaPerusahaan_terjamin = MutableLiveData<String>()
    val data_noTelepon_terjamin = MutableLiveData<String>()
    val data_klasifikasi_perusahaan_terjamin = MutableLiveData<String>()

    //data BOD
    val data_nama_BOD = MutableLiveData<String>()
    val data_NIK_BOD = MutableLiveData<String>()
    val data_NoTelp_BOD = MutableLiveData<String>()
    val data_Email_BOD = MutableLiveData<String>()
    val data_Jabatan_BOD = MutableLiveData<String>()

    //dataPenanggungjawab
    val data_nama_penanggungJawabProyek = MutableLiveData<String>()
    val data_NIK_penanggungJawabProyek = MutableLiveData<String>()
    val data_noTelp_penanggungJawabProyek = MutableLiveData<String>()
    val data_email_penanggungJawabProyek = MutableLiveData<String>()
    val data_jabatan_penanggungJawabProyek = MutableLiveData<String>()

    //data PIC
    val data_BOD_inPIC = MutableLiveData<String>()
    val data_nama_PIC = MutableLiveData<String>()
    val data_jabatan_PIC = MutableLiveData<String>()
    val data_noTelp_PIC = MutableLiveData<String>()
    val data_email_PIC = MutableLiveData<String>()
    val data_NIK_PIC = MutableLiveData<String>()

    //data WanPrestasi
    val data_Wanprestasi = MutableLiveData<String>()
    val data_subrogasi = MutableLiveData<String>()

    //data Hukum
    val data_hukum = MutableLiveData<String>()
    val data_jenisHukum = MutableLiveData<String>()

    //data perusahaan terjamin
    val data_namaPerusahaanPenerimaJaminan = MutableLiveData<String>()
    val data_bentukBadanHukum = MutableLiveData<String>()
    val data_statusBadanHukum = MutableLiveData<String>()
    val data_provinsiPerusahaanPenerimaJaminan = MutableLiveData<String>()
    val data_kotaPersahaanPenerimaJaminan = MutableLiveData<String>()
    val data_kecamtanPerusahaanPenerimaJaminan = MutableLiveData<String>()
    val data_kelurahanPerusahaanPenerimaJaminan = MutableLiveData<String>()
    val data_alamatPerusahaanPenerimaJaminan = MutableLiveData<String>()

}

