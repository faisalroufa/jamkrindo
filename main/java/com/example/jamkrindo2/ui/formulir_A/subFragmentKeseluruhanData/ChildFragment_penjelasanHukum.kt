package com.example.jamkrindo2.ui.formulir_A.subFragmentKeseluruhanData


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner

import com.example.jamkrindo2.R
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.child_fragment_penjelasan_hukum.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ChildFragment_penjelasanHukum : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.child_fragment_penjelasan_hukum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        jenishukum()
        pilihanJenisHukum.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val pilihanjenishukum = parent?.getItemAtPosition(position).toString()
                SharedViewModel?.data_jenisHukum?.value = pilihanjenishukum
            }
        }
    }

    fun jenishukum() {
        val spinner: Spinner = view!!.findViewById(R.id.pilihanJenisHukum)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context,
            R.array.jenishukum,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
}
