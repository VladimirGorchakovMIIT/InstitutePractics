package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.models.User
import com.example.institutepractics.unit.interfaces.OnNavigationApplication

class RegistrationFragment : Fragment() {

    private lateinit var loginRedirectText: TextView
    private lateinit var signupUsername: EditText
    private lateinit var signupEmail: EditText
    private lateinit var signupPassword: EditText
    private lateinit var signupConfirmPassword: EditText
    private lateinit var registrationButton: Button
    private lateinit var view:View
    private lateinit var onNavigationApplication: OnNavigationApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view = inflater.inflate(R.layout.fragment_registration, container,false)

        init(view)

        loginRedirectText.setOnClickListener {
            openLoginFragment()
        }

        registrationButton.setOnClickListener {
            if(signupPassword.text.toString() == signupConfirmPassword.text.toString()){

                Database.addUser(
                    User(signupUsername.text.toString(),
                    signupEmail.text.toString(),
                    signupPassword.text.toString())
                )

                openLoginFragment()
            }
        }

        return view
    }

    private fun init(view:View){
        loginRedirectText = view.findViewById(R.id.loginRedirectText)
        signupUsername = view.findViewById(R.id.signup_username)
        signupEmail = view.findViewById(R.id.signup_email)
        signupPassword = view.findViewById(R.id.signup_password)
        signupConfirmPassword = view.findViewById(R.id.signup_confirm_password)
        registrationButton = view.findViewById(R.id.registration_button)

        onNavigationApplication = requireActivity() as OnNavigationApplication
    }

    private fun openLoginFragment(){
        onNavigationApplication.openLoginFragment()
    }
}