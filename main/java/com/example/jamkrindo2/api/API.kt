package com.example.jamkrindo2.api

import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class  API() {
    fun fetchJSON() {
        val url = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
            this.fetchJSON()
        val request = Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }

            override fun onResponse(call: Call, response: Response) {
                val `object` = JSONObject(response.body()?.string())
                val Jarray = `object`.getJSONArray("semuaprovinsi")
                var namaProvinsi: MutableList<String> = mutableListOf<String>()
                var idProvinsi: MutableList<String> = mutableListOf<String>()
                var a = 0
                for (index in 0 until Jarray.length()) {
                    val Jasonobject = Jarray.getJSONObject(index)
                    var id = Jasonobject.getInt("id").toString()
                    var nama = Jasonobject.getString("nama")
                    namaProvinsi.add(nama)
                    idProvinsi.add(id)
                }
//                provinsi(namaProvinsi, idProvinsi)
            }
        })
    }
}