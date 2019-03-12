package com.example.jamkrindo2.ui.formulir_A


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.jamkrindo2.R
import com.example.jamkrindo2.ui.formulir_A.subFragmentKeseluruhanData.ChildFragment_Subrogasi
import com.example.jamkrindo2.util.SharedModel
import kotlinx.android.synthetic.main.fragment_form1_fragment_lima.*




class form1_fragment_wanprestasi : Fragment() {
    private var SharedViewModel : SharedModel? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_form1_fragment_lima, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        wanprestasi()
//        subrogasi()
        activity.let {
            SharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedModel::class.java)
        }
        pilihanWanprestasi.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val datapilihanWanPrestasi = parent?.getItemAtPosition(position).toString()
                SharedViewModel?.data_Wanprestasi?.value = datapilihanWanPrestasi
                val fragment = childFragmentManager.fragments
                if (position == 3 && fragment.isEmpty()){
                    addFragment(ChildFragment_Subrogasi(),R.id.frame_subrogasi)
                    println("add subrogasi")
                }else {
                    removeFragment(R.id.frame_subrogasi)
                    SharedViewModel?.data_subrogasi?.value = null
                    println("remove subrogasi")
                }
            }

        }
    }

    fun AdapterView<Adapter>.itemListener(item : (String)->(Unit)){
        this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                item.invoke(parent?.getItemAtPosition(position).toString())
            }

        }
    }
    fun wanprestasi() {
        val spinner: Spinner = view!!.findViewById(R.id.pilihanWanprestasi)
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            context,
            R.array.wanprestasi,
            android.R.layout.simple_spinner_item

        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }
//    fun subrogasi() {
//        val spinner: Spinner = view!!.findViewById(R.id.pilihanSubrogasi)
//// Create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            context,
//            R.array.subrogasi,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
//    }
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
