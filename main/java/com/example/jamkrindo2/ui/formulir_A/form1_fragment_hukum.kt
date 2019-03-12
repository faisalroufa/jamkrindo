package com.example.jamkrindo2.ui.formulir_A


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
import com.example.jamkrindo2.ui.formulir_A.subFragmentKeseluruhanData.ChildFragment_penjelasanHukum
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.fragment_form1_fragment_enam.*


class form1_fragment_hukum : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form1_fragment_enam, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hukum()
        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        pilihanHukum.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val pilihanHukum = parent?.getItemAtPosition(position).toString()
                SharedViewModel?.data_hukum?.value = pilihanHukum
                val fragment = childFragmentManager.fragments
                if (position == 0){
                    removeFragment(R.id.frame_penjelasanHukum)
                    SharedViewModel?.data_jenisHukum?.value = null
                }else if (fragment.isEmpty()){
                    addFragment(ChildFragment_penjelasanHukum(),R.id.frame_penjelasanHukum)
                }
            }
        }
    }
        fun hukum() {
            val spinner: Spinner = view!!.findViewById(R.id.pilihanHukum)
    // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter.createFromResource(
                context,
                R.array.hukum,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }
        fun addFragment(Fragment : Fragment, container:Int){
            childFragmentManager.beginTransaction()
                .add(container,Fragment)
                .commit()
        }
        fun removeFragment(Fragment : Int){
            val fragment = childFragmentManager.findFragmentById(Fragment)
            val fr = childFragmentManager.beginTransaction()
            fragment?.let { fr.remove(it) }
            fr.commit()
            println("remove fragment")
        }

    }

