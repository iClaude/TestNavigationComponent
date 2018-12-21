package com.example.android.codelabs.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class TestFragment : Fragment() {

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

}
