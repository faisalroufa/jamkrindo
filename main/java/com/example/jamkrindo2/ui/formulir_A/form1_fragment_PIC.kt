package com.example.jamkrindo2.ui.formulir_A


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.jamkrindo2.R
import kotlinx.android.synthetic.main.fragment_form1_fragment_empat.*
import com.example.jamkrindo2.util.Broilerplate
import com.example.jamkrindo2.util.SharedModel

class form1_fragment_PIC : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form1_fragment_empat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inputData()
    }
    private fun inputData(){
        SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        namaBODPIC.textListener {
            this.SharedViewModel!!.data_nama_PIC.value = it
        }
        namaPIC.textListener {
            this.SharedViewModel!!.data_nama_PIC.value = it
        }
        jabatanPIC.textListener {
            this.SharedViewModel!!.data_jabatan_PIC.value = it
        }
        NIKPIC.textListener {
            this.SharedViewModel!!.data_NIK_PIC.value = it
        }
        noTelpPIC.textListener {
            this.SharedViewModel!!.data_noTelp_PIC.value = it
        }
        emailPIC.textListener {
            this.SharedViewModel!!.data_email_PIC.value = it
        }
    }
    private fun EditText.textListener(aftertextchanged :(String)->(Unit)){
        this.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                aftertextchanged.invoke(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

    }


}
