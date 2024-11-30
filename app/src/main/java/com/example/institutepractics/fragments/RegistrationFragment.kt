package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.databinding.FragmentRegistrationBinding
import com.example.institutepractics.models.User

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding

    private lateinit var loginRedirectText: TextView
    private lateinit var signupUsername: EditText
    private lateinit var signupEmail: EditText
    private lateinit var signupPassword: EditText
    private lateinit var signupConfirmPassword: EditText
    private lateinit var registrationButton: Button
    private lateinit var bundle: Bundle

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        //Редирект на страницу с логином и паролем
        loginRedirectText.setOnClickListener {
            MAIN_AUTHORIZATION.navControllerAuthorization.navigate(R.id.action_registrationFragment_to_loginFragment)
        }

        //Кнопка регистрации
        registrationButton.setOnClickListener {
            if (signupPassword.text.toString() == signupConfirmPassword.text.toString()) {

                Database.addUser(
                    User(
                        signupUsername.text.toString(),
                        signupEmail.text.toString(),
                        signupPassword.text.toString()
                    )
                )

                MAIN_AUTHORIZATION.navControllerAuthorization.navigate(R.id.action_registrationFragment_to_loginFragment)
            }
        }
    }

    private fun init() {
        loginRedirectText = binding.loginRedirectText
        signupUsername = binding.signupUsername
        signupEmail = binding.signupEmail
        signupPassword = binding.signupPassword
        signupConfirmPassword = binding.signupConfirmPassword
        registrationButton = binding.registrationButton
        bundle = Bundle()
    }
}