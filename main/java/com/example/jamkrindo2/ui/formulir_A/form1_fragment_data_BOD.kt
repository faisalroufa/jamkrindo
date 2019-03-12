package com.example.jamkrindo2.ui.formulir_A


import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.jamkrindo2.R
import com.example.jamkrindo2.ui.childFragment.biodata_penanggungJawab
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.fragment_form1_fragment_dua.*


class form1_fragment_dua : Fragment() {
    private var sharedViewModel : SharedModel? =null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form1_fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinner_Jabatan()
        activity.let {
            sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        jabatanBOD.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val input_Jabatan = parent?.getItemAtPosition(position).toString()
                sharedViewModel?.data_Jabatan_BOD?.postValue(input_Jabatan)
            }
        }
//        pindahDataBOD()
        activity?.let {
            sharedViewModel = ViewModelProviders.of(activity!!).get(SharedModel::class.java)
        }

        //input data to view model
        inputNamaBOD.InputListener {
            sharedViewModel?.data_nama_BOD?.postValue(it)
            println("Nama " + it)
        }
        inputNIKBOD.InputListener {
            sharedViewModel?.data_NIK_BOD?.postValue(it)
            println("int NIK " + it)
        }
        inputNoTelpBOD.InputListener {
            sharedViewModel?.data_NoTelp_BOD?.postValue(it)
            println("int Telp " + it)
        }
        inputEmailBOD.InputListener {
            sharedViewModel?.data_Email_BOD?.postValue(it)
            println("Email " + it)
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
    fun spinner_Jabatan() {
        val spinner = view!!.findViewById<Spinner>(R.id.jabatanBOD)
        ArrayAdapter.createFromResource(
            context,
            R.array.jabatan,
            android.R.layout.simple_list_item_1
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinner.adapter = adapter
        }
    }
}
