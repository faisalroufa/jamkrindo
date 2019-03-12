package com.example.jamkrindo2.ui.formulir_A


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_form1_fragment_satu.*
import android.widget.AdapterView
import com.example.jamkrindo2.R
import com.example.jamkrindo2.ui.childFragment.ChildFragment_Alamat
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.form_satu_main.*


class form1_fragment_dataPerusahaan : Fragment() {
    private var sharedViewModel: SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form1_fragment_satu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val childFragments = childFragmentManager.getFragments()
        if (childFragments.isEmpty()) {
            val fragment = childFragmentManager.beginTransaction()
            fragment.add(R.id.frame_alamatcontainer, ChildFragment_Alamat())
            fragment.commit()
        }

            data_alamat()
            activity?.let {
                sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
            }

            namaPerusahaanTerjamin.afterTextChanged {
                sharedViewModel?.data_namaPerusahaan_terjamin?.postValue(it)
            }

            noTelpPerusahaan.afterTextChanged {
                sharedViewModel?.data_noTelepon_terjamin?.postValue(it)
            }
            klasifikasiPerusahaan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val data_klasifikasi_perusahaan = parent?.getItemAtPosition(position).toString()
                    sharedViewModel?.data_klasifikasi_perusahaan_terjamin?.postValue(data_klasifikasi_perusahaan)
                }
            }
        pindahdataAlamat()
     }



     fun data_alamat() {
//        provinsi()
         klasifikasi()

     }
     fun klasifikasi() {
         val spinner: Spinner = view!!.findViewById(R.id.klasifikasiPerusahaan)
// Create an ArrayAdapter using the string array and a default spinner layout
         ArrayAdapter.createFromResource(
             requireContext(),
             R.array.klasifikasiPerusahaan,
             R.layout.custom_layout_spinner_item
         ).also { adapter ->
             // Specify the layout to use when the list of choices appears
             adapter.setDropDownViewResource(R.layout.custom_layout_spinner_dropdown_item)
             // Apply the adapter to the spinner
             spinner.adapter = adapter

         }

     }
    fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
        this.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                afterTextChanged.invoke(p0.toString())
            }

            override fun afterTextChanged(editable: Editable?) {

            }
        })
    }
    private fun pindahdataAlamat(){
        activity?.let {
            sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        sharedViewModel?.input_alamat?.observe(this, Observer {
            it?.let {
                sharedViewModel!!.data_alamat_terjamin.postValue(it)
                println(" data input alamat $it")
            }
        })
        sharedViewModel?.input_Provinsi?.observe(this, Observer {
            it?.let {
                sharedViewModel!!.data_Provinsi_terjamin.postValue(it)
                println(it)
            }
        })
        sharedViewModel?.input_Kota?.observe(this, Observer {
            it?.let {
                sharedViewModel!!.data_Kota_terjamin.postValue(it)
            }
        })
        sharedViewModel?.input_Kecamatan?.observe(this, Observer {
            it?.let {
                sharedViewModel!!.data_Kecamatan_terjamin.postValue(it)
            }
        })
        sharedViewModel?.input_Kelurahan?.observe(this, Observer {
            it?.let {
                sharedViewModel!!.data_Kelurahan_terjamin.postValue(it)
            }
        })
//        sharedViewModel?.input_alamat?.removeObservers(requireActivity())
//        sharedViewModel?.input_Kelurahan?.removeObservers(requireActivity())
//        sharedViewModel?.input_Kecamatan?.removeObservers(requireActivity())
//        sharedViewModel?.input_Kota?.removeObservers(requireActivity())
//        sharedViewModel?.input_Provinsi?.removeObservers(requireActivity())
    }
    //    fun provinsi() {
////        val data:dataprovinsi = ambilDataProvinsi()
////        var(idProvinsi,namaProvinsi) = data
//        val textView = view?.findViewById(R.id.provinsi) as AutoCompleteTextView
//        val adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, namaProvinsi)
//        activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })
//
//    }
   //     fun ambilDataProvinsi(): dataprovinsi {
//         var url = "http://dev.farizdotid.com/api/daerahindonesia/provinsi"
//         println(url)
//         var dataJSON = API(url)
//
//         val `object` = JSONObject(dataJSON)
//         val Jarray = `object`.getJSONArray("semuaprovinsi")
//         var namaProvinsi: MutableList<String> = mutableListOf<String>()
//         var idProvinsi: MutableList<String> = mutableListOf<String>()
//
//         for (index in 0 until Jarray.length()) {
//             val Jasonobject = Jarray.getJSONObject(index)
//             var id = Jasonobject.getString("id")
//             var nama = Jasonobject.getString("nama")
//             namaProvinsi.add(nama)
//             idProvinsi.add(id)
//         }
//         return dataprovinsi(idProvinsi, namaProvinsi)
//     }

        //    @Throws(IOException::class)
}