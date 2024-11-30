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
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.unit.interfaces.OnNavigationApplication

class LoginFragment : Fragment() {

    private lateinit var loginRedirectText: TextView
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var database: Database
    private lateinit var view : View
    private lateinit var onNavigationApplication: OnNavigationApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false)

        init(view)

        loginButton.setOnClickListener {
            if (loginUsername.text.isEmpty() || loginPassword.text.isEmpty())
                Toast.makeText(context, "Need write login or password", Toast.LENGTH_SHORT).show()

            if (Database.checkUser(loginUsername.text.toString(), loginPassword.text.toString())) {
                onNavigationApplication.openWelcomePage(loginUsername.text.toString())
            } else
                Toast.makeText(context, "Not correct login or password", Toast.LENGTH_SHORT).show()
        }

        loginRedirectText.setOnClickListener {
            onNavigationApplication.openRegistrationFragment()
        }

        return view
    }

    private fun init(view:View){
        loginRedirectText = view.findViewById(R.id.loginRedirectText)
        loginUsername = view.findViewById(R.id.login_username)
        loginPassword = view.findViewById(R.id.login_password)
        loginButton = view.findViewById(R.id.login_button)

        onNavigationApplication = requireActivity() as OnNavigationApplication
    }
}