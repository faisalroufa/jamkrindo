package com.example.jamkrindo2.util

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class Broilerplate {
    fun EditText.textListener(aftertextchanged :(String)->(Unit)){
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