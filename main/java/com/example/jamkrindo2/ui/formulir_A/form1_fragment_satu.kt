package com.example.jamkrindo2.ui.formulir_A


import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_form1_fragment_satu.*
import okhttp3.*
import java.io.IOException
import org.json.JSONObject
import com.example.jamkrindo2.R
import okhttp3.OkHttpClient

 class form1_fragment_satu : Fragment() {

     override fun onCreateView(
         inflater: LayoutInflater, container: ViewGroup?,
         savedInstanceState: Bundle?
     ): View? {
         return inflater.inflate(R.layout.fragment_form1_fragment_satu, container, false)

     }

     override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
//         data_alamat()
//         parseJSONprovinsi()


         //        provinsi.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//        })
//        provinsi.afterTextChanged {
//            val pilihanProvinsi = provinsi.getText().toString()
//            val idProvinsi = passingIDProvinsi(pilihanProvinsi)
////            val idKabupaten = APIKabupaten.parseJSONKabupaten(idProvinsi)
////            println(idProvinsi)
//
//        }
//
//        kota.addTextChangedListener(object : TextWatcher {
//            override fun afterTextChanged(p0: Editable?) {
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//        })
//        kota.afterTextChanged {
//            val pilihanProvinsi = provinsi.getText().toString()
//            val pilihanKota = kota.getText().toString()
//            val idProvinsi = passingIDProvinsi(pilihanProvinsi).toString()
//            val idKota = passingIDKota(idProvinsi,pilihanKota)
////            val idKabupaten = APIKabupaten.parseJSONKabupaten(idProvinsi)
//            println(idProvinsi)
//            println(pilihanKota)
//
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//
//    }
//
//    fun data_alamat() {
//        val prov = ::provinsi
//        prov
//        kota
//        klasifikasi()
//    }
         data class ID(var idProvinsi: String = "", var namaKota: String = "")

         fun storeIdProvinsi(idProvinsi: String) {
             var newid = idProvinsi
//        println(newid)
         }

         fun provinsi(namaProvinsi: MutableList<String>, idProvinsi: MutableList<String>) {
             val textView = view?.findViewById(R.id.provinsi) as AutoCompleteTextView
             val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, namaProvinsi)
             activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })

         }

         fun kabupaten(namaKabupaten: MutableList<String>, idKabupaten: MutableList<String>) {
             val textView = view?.findViewById(R.id.kota) as AutoCompleteTextView
             val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, namaKabupaten)
             activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })

         }

         fun kecamatan(namaKecamatan: MutableList<String>, idKecamatan: MutableList<String>) {
             val textView = view?.findViewById(R.id.kecamatan) as AutoCompleteTextView
             val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, namaKecamatan)
             activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })

         }

         fun klasifikasi() {
             val spinner: Spinner = view!!.findViewById(R.id.klasifikasiPerusahaan)
// Create an ArrayAdapter using the string array and a default spinner layout
             ArrayAdapter.createFromResource(
                 context,
                 R.array.klasifikasiPerusahaan,
                 android.R.layout.simple_spinner_item
             ).also { adapter ->
                 // Specify the layout to use when the list of choices appears
                 adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                 // Apply the adapter to the spinner
                 spinner.adapter = adapter

             }

         }

         fun parseJSONprovinsi() {
             val urlProvinsi = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
             val urlKabupaten = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/12/kabupaten"
             val urlKecamatan =
                 "http://dev.farizdotid.com/api/daerahindonesia/provinsi/kabupaten/{idkabupaten}/kecamatan"
             val request = Request.Builder().url(urlProvinsi).build()
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

                     for (index in 0 until Jarray.length()) {
                         val Jasonobject = Jarray.getJSONObject(index)
                         var id = Jasonobject.getInt("id").toString()
                         var nama = Jasonobject.getString("nama")
                         namaProvinsi.add(nama)
                         idProvinsi.add(id)
                     }
                     provinsi(namaProvinsi, idProvinsi)
                 }
             })
         }

         //passing ID dari input
         fun passingIDProvinsi(namaProvinsi: String) {
             val urlProvinsi = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
             val request = Request.Builder().url(urlProvinsi).build()
             val client = OkHttpClient()

             var namaProvinsi = namaProvinsi
//                println(namaProvinsi)
             client.newCall(request).enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {
                     println("Failed to execute request")
                 }

                 override fun onResponse(call: Call, response: Response) {
                     val `object` = JSONObject(response.body()?.string())
                     val Jarray = `object`.getJSONArray("semuaprovinsi")

                     for (index in 0 until Jarray.length()) {
                         val Jasonobject = Jarray.getJSONObject(index)
                         var id = Jasonobject.getString("id")
                         var nama = Jasonobject.getString("nama")
                         var idProvinsi: String
                         if (namaProvinsi.equals(nama)) {
                             idProvinsi = id
//                                println(id)
//                                parseJSONKota(idProvinsi)
                             storeIdProvinsi(idProvinsi)
                         } else {
                         }
                     }

                 }
             })
         }

         fun parseJSONKota(idProvinsi: String) {
             //                    val url = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
             val a = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/"
             val b = "/kabupaten"
             val url = a + idProvinsi + b

             println(url)
             val client = OkHttpClient()

             val request = Request.Builder()
                 .url(url)
                 .build()

             client.newCall(request).enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {
                     println("Failed to execute request")
                 }

                 override fun onResponse(call: Call, response: Response) {
                     val `object` = JSONObject(response.body()?.string())
                     val Jarray = `object`.getJSONArray("kabupatens")
                     var namaKabupaten: MutableList<String> = mutableListOf<String>()
                     var idKabupaten: MutableList<String> = mutableListOf<String>()

                     for (index in 0 until Jarray.length()) {
                         val Jasonobject = Jarray.getJSONObject(index)
                         var id = Jasonobject.getString("id")
                         var nama = Jasonobject.getString("nama")
                         namaKabupaten.add(nama)
                         idKabupaten.add(id)

                     }
                     kabupaten(namaKabupaten, idKabupaten)
//                println(idProvinsi)
//                println(namaKabupaten)
                 }
             })
         }

         fun passingIDKota(idProvinsi: String, namaKota: String) {
             val a = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/"
             val b = "/kabupaten"
             val url = a + idProvinsi + b
             println(idProvinsi)
             println(namaKota)

             val request = Request.Builder().url(url).build()
             val client = OkHttpClient()

             client.newCall(request).enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {
                     println("Failed to execute request")
                 }

                 override fun onResponse(call: Call, response: Response) {
                     val `object` = JSONObject(response.body()?.string())

                     val Jarray = `object`.getJSONArray("kabupatens")
                     var idKota: String
                     var namaKota = namaKota
                     for (index in 0 until Jarray.length()) {
                         val Jasonobject = Jarray.getJSONObject(index)
                         var id = Jasonobject.getString("id")
                         var nama = Jasonobject.getString("nama")
                         if (namaKota.equals(nama)) {
                             idKota = id
//                        println(idKota)
//                        parseJSONKecamatan(idKota)
                         } else {
                         }
                     }

                 }
             })
         }

         //    fun parseJSONKecamatan(idKabupaten: String) {
//        //                    val url = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
//        val a = "http:dev.farizdotid.com/api/daerahindonesia/provinsi/kabupaten/"
//        val b = "/kecamatan"
//        val url = a + idProvinsi + b
//        println(url)
//        val client = OkHttpClient()
//
//        val request = Request.Builder()
//            .url(url)
//            .build()
//
//        client.newCall(request).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                println("Failed to execute request")
//            }
//            override fun onResponse(call: Call, response: Response) {
//                val `object` = JSONObject(response.body()?.string())
//                val Jarray = `object`.getJSONArray("daftar_kecamatan")
//                var namaKecamatan: MutableList<String> = mutableListOf<String>()
//                var idKecamatan: MutableList<String> = mutableListOf<String>()
//
//                for (index in 0 until Jarray.length()) {
//                    val Jasonobject = Jarray.getJSONObject(index)
//                    var id = Jasonobject.getString("id")
//                    var nama = Jasonobject.getString("nama")
//                    namaKecamatan.add(nama)
//                    idKecamatan.add(id)
//                }
//                kecamatan(namaKecamatan,idKecamatan)
//            }
//        })
//    }
         fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
             this.addTextChangedListener(object : TextWatcher {
                 override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                 }

                 override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                 }

                 override fun afterTextChanged(editable: Editable?) {
                     afterTextChanged.invoke(editable.toString())
                 }
             })
         }
//                  val urlKecamatan = "http://dev.farizdotid.com/api/daerahindonesia/provinsi/kabupaten/{idkabupaten}/kecamatan
     }
 }