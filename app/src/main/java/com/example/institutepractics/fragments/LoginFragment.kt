package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.databinding.FragmentLoginBinding
import com.example.institutepractics.models.User

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    private lateinit var registrationUser: TextView
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var database: Database

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
                val user: User? = Database.getUser(loginUsername.text.toString())
                val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(user?.name.toString(), user?.email.toString())

                findNavController().navigate(action)
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
    }
}