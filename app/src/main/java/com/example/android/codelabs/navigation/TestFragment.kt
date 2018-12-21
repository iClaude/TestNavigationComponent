package com.example.android.codelabs.navigation


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class TestFragment : Fragment() {

    companion object {
        private const val TAG: String = "TestFragment"
    }

    var myName: String? = null

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG, "onDestroy() called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val args = TestFragmentArgs.fromBundle(arguments)
        val msg1 = args.testArgument1
        val msg2 = args.testArgument2

        val view = inflater.inflate(R.layout.test_fragment, container, false)
        view.findViewById<TextView>(R.id.tvHello1).text = msg1
        view.findViewById<TextView>(R.id.tvHello2).text = msg2

        view.findViewById<Button>(R.id.bShowMessage).setOnClickListener {
            view.findViewById<TextView>(R.id.tvMessage).text = "message arrived"
        }

        return view
    }

    fun setTheName(name: String) {
        myName = name
    }

}
