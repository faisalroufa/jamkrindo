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
import com.example.jamkrindo2.R
import com.example.jamkrindo2.ui.childFragment.ChildFragment_Alamat
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.form_satu_main.*
import kotlinx.android.synthetic.main.fragment_form1_fragment_penerima_jaminan.*
import okhttp3.*
import org.json.JSONObject




class form1_fragment_penerimaJaminan : Fragment() {
    lateinit var  SharedViewModel : SharedModel
    lateinit var alamat: String
     var provinsi: String? = null
    lateinit var kecamatan: String
    lateinit var kelurahan: String
    lateinit var kota: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form1_fragment_penerima_jaminan, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
            spinnerBentukBadanHukum()
            spinnerStatusBadanHukum()

            namaPerusahaanPenerimaJaminan.afterTextChanged {
                SharedViewModel?.data_namaPerusahaanPenerimaJaminan?.value = it
            }
            bentukBadanHukum.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val pilihanBadanHukum = parent?.getItemAtPosition(position).toString()
                    SharedViewModel?.data_bentukBadanHukum?.value = pilihanBadanHukum
                }
            }
            statusBadanHukum.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    val pilihanStatusHukum = parent?.getItemAtPosition(position).toString()
                    SharedViewModel?.data_statusBadanHukum?.value = pilihanStatusHukum
                }
            }
        alamatPenerimaJaminan.afterTextChanged {
            SharedViewModel!!.data_alamatPerusahaanPenerimaJaminan.postValue(it)}
        provinsiPenerimaJaminan.afterTextChanged {
            SharedViewModel?.data_provinsiPerusahaanPenerimaJaminan?.postValue(it) }
        kotaPenerimaJaminan.afterTextChanged {
            SharedViewModel?.data_kotaPersahaanPenerimaJaminan?.postValue(it) }
        kecamatanPenerimaJaminan.afterTextChanged {
            SharedViewModel?.data_kecamtanPerusahaanPenerimaJaminan?.postValue(it) }
        kelurahanPenerimaJaminan.afterTextChanged {
            SharedViewModel?.data_kelurahanPerusahaanPenerimaJaminan?.postValue(it) }

    }

    fun provinsi2(namaProvinsi: MutableList<String>, idProvinsi: MutableList<String>) {

//        val textView = view?.findViewById(R.id.provinsi2) as AutoCompleteTextView
//        val adapter = ArrayAdapter<String>(context,android.R.layout.simple_list_item_1, data)
//            activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })

        }
    fun kota() {
        val textView = view?.findViewById(R.id.kota) as AutoCompleteTextView
        // Get the string array
        val countries: Array<out String> = this.resources.getStringArray(R.array.kota)
// Create the adapter and set it to the AutoCompleteTextView

        ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, countries).also { adapter ->
            activity?.runOnUiThread(Runnable { textView.setAdapter(adapter) })

        }
    }
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
    fun spinnerBentukBadanHukum() {
        val spinner: Spinner = view!!.findViewById(R.id.bentukBadanHukum)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context,
            R.array.bentukbadanHukum,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
    fun spinnerStatusBadanHukum() {
        val spinner: Spinner = view!!.findViewById(R.id.statusBadanHukum)
// Create an ArrayAdapter using the string array and a default spinner layout

        ArrayAdapter.createFromResource(
            context,
            R.array.statusbadanHukum,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}

