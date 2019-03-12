package com.example.jamkrindo2.api

import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import com.example.jamkrindo2.util.SharedModel
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class apiProvinsi {
    private var SharedViewModel : SharedModel? = null
    lateinit var namaProvinsi: MutableList<String>
    lateinit var idProvinsi: MutableList<String>
    fun parseJSONprovinsi() {
        val urlProvinsi = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
        val urlKabupaten = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/12/kabupaten"
        val urlKecamatan = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/kabupaten/{idkabupaten}/kecamatan"
        val request = Request.Builder().url(urlProvinsi).build()
        val client = OkHttpClient()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val `object` = JSONObject(response.body()?.string())
                val Jarray = `object`.getJSONArray("semuaprovinsi")
                let {
                    SharedViewModel = ViewModelProviders.of(FragmentActivity()).get(SharedModel::class.java)
                }

            }
        })

    }
    init {

    }
}