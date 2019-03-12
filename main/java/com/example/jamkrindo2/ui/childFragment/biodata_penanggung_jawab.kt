package com.example.jamkrindo2.ui.childFragment


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner

import com.example.jamkrindo2.R
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.fragment_form1_fragment_penanggung_jawab_proyek.*

/**
 * A simple [Fragment] subclass.
 *
 */
class biodata_penanggungJawab : Fragment() {
    private var sharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form1_fragment_penanggung_jawab_proyek, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            sharedViewModel = ViewModelProviders.of(activity!!).get(SharedModel::class.java)
        }
        jabatan_penanggungJawabProyek.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val jabatan = parent?.getItemAtPosition(position).toString()
                sharedViewModel?.data_jabatan_penanggungJawabProyek?.postValue(jabatan)
//                println(jabatan)
            }
        }
        spinnerJabatanPenanggungJawab()
        //input data to view model
        inputNamaPenanggungJawabProyek.InputListener {
            sharedViewModel?.data_nama_penanggungJawabProyek?.postValue(it)
            println("Nama "+it)
        }
        inputNIKPenanggungJawabProyek.InputListener {
            sharedViewModel?.data_NIK_penanggungJawabProyek?.postValue(it)
            println("int NIK "+it)
        }
        inputNoTelpPenanggungJawabProyek.InputListener {
            sharedViewModel?.data_noTelp_penanggungJawabProyek?.postValue(it)
            println("int Telp "+it)
        }
        inputEmailPenanggungJawabProyek.InputListener {
            sharedViewModel?.data_email_penanggungJawabProyek?.postValue(it)
            println("Email "+it)
        }
    }
    fun spinnerJabatanPenanggungJawab(){
        val spinner = view?.findViewById<Spinner>(R.id.jabatan_penanggungJawabProyek)
        ArrayAdapter.createFromResource(
            context,
            R.array.jabatan,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner?.adapter = adapter
        }
    }
    fun  EditText.InputListener(InputListener : (String)->(Unit)){
        this.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                InputListener.invoke(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }
}
