package com.example.jamkrindo2.ui.childFragment


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
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.fragment_fragment_alamat.*

class ChildFragment_Alamat : Fragment() {
    private var sharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_alamat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let {
            sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }

        alamat.afterTextChanged {
            sharedViewModel!!.input_alamat.postValue(it)}
        provinsi.afterTextChanged {
            sharedViewModel?.input_Provinsi?.postValue(it) }
        kota.afterTextChanged {
            sharedViewModel?.input_Kota?.postValue(it) }
        kecamatan.afterTextChanged {
            sharedViewModel?.input_Kecamatan?.postValue(it) }
        kelurahan.afterTextChanged {
            sharedViewModel?.input_Kelurahan?.postValue(it) }

    }
    private fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
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
}
