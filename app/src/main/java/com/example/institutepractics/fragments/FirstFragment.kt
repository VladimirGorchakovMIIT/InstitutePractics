package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.institutepractics.R
import com.example.institutepractics.unit.interfaces.OnPassDataCommunicator


class FirstFragment : Fragment() {

    private lateinit var buttonEnter: Button
    private lateinit var editInputText: EditText

    private lateinit var onPassDataCommunicator: OnPassDataCommunicator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)
        init(rootView)

        buttonEnter.setOnClickListener {
            onPassDataCommunicator.passData(editInputText.text.toString())
        }


        return rootView
    }

    private fun init(view:View){
        buttonEnter = view.findViewById(R.id.buttonEnter)
        editInputText = view.findViewById(R.id.editTextEnter)
        onPassDataCommunicator = requireActivity() as OnPassDataCommunicator
    }
}