package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.institutepractics.R

class WelcomeFragment : Fragment() {

    private lateinit var titleUsername : TextView
    private lateinit var titleEmail : TextView

    private lateinit var username:String
    private lateinit var email: String

    private lateinit var view : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_welcome, container, false)

        init(view)

        titleUsername.text = username
        titleEmail.text = email

        return view
    }

    private fun init(view:View){
        titleUsername = view.findViewById(R.id.titleUsername)
        titleEmail = view.findViewById(R.id.titleEmail)

        username = arguments?.getString("username").toString()
        email = arguments?.getString("email").toString()
    }
}