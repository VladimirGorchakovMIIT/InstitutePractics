package com.example.institutepractics.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.activities.WelcomeActivity
import com.example.institutepractics.database.Database
import com.example.institutepractics.databinding.FragmentLogin2Binding
import com.example.institutepractics.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLogin2Binding


    private val TAG: String = "MyApp"

    private lateinit var registrationUser: TextView
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var database: Database



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLogin2Binding.inflate(layoutInflater, container, false)
        Toast.makeText(context, "onCreateView!", Toast.LENGTH_SHORT).show()

        return inflater.inflate(R.layout.fragment_login2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        Toast.makeText(context, "OnViewCreated!", Toast.LENGTH_SHORT).show()

        loginButton.setOnClickListener {
            Toast.makeText(context, "Need write login or password", Toast.LENGTH_SHORT).show()
        }
    }

    private fun init() {
        registrationUser = binding.loginRedirectText2
        loginUsername = binding.loginUsername
        loginPassword = binding.loginPassword
        loginButton = binding.loginButton
        database = Database();
    }

}