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
import androidx.navigation.fragment.findNavController
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.activities.RegistrationActivity
import com.example.institutepractics.activities.WelcomeActivity
import com.example.institutepractics.database.Database
import com.example.institutepractics.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private val TAG: String = "MyApp"

    private lateinit var registrationUser: TextView
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var database: Database
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        loginButton.setOnClickListener {
            if (loginUsername.text.isEmpty() || loginPassword.text.isEmpty())
                Toast.makeText(context, "Need write login or password", Toast.LENGTH_SHORT).show()

            if (Database.checkUser(loginUsername.text.toString(), loginPassword.text.toString())) {
                /*var intent = Intent(context, WelcomeActivity::class.java).apply {
                    Log.d(TAG, "Test application" + Database.getUser(loginUsername.text.toString()))
                    putExtra("email", Database.getUser(loginUsername.text.toString())?.name)
                    putExtra("Object", Database.getUser(loginUsername.text.toString()))
                }
                startActivity(intent)*/

                bundle.putString("MyArgs", "Hello my world")
                findNavController().navigate(R.id.welcomeFragment, bundle)
            } else
                Toast.makeText(context, "Not correct login or password", Toast.LENGTH_SHORT).show()
        }

        registrationUser.setOnClickListener {
            MAIN_AUTHORIZATION.navControllerAuthorization.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    private fun init() {
        registrationUser = binding.loginRedirectText
        loginUsername = binding.loginUsername
        loginPassword = binding.loginPassword
        loginButton = binding.loginButton
        database = Database()
        bundle = Bundle()
    }
}