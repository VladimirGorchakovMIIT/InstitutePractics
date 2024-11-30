package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.institutepractics.R

class SecondFragment : Fragment() {

    private lateinit var textTitleFragment:TextView
    private lateinit var getInputData:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)
        init(rootView)

        textTitleFragment.text = getInputData


        return rootView
    }

    private fun init(view:View){
        textTitleFragment = view.findViewById(R.id.textTitleFragment)
        getInputData = arguments?.getString("inputText").toString()
    }
}