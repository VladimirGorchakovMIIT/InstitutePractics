package com.example.institutepractics.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.models.User

class RegistrationActivity : AppCompatActivity() {
    private val TAG: String = "MyApp"

    private lateinit var loginRedirectText: TextView
    private lateinit var signupUsername:EditText
    private lateinit var signupEmail:EditText
    private lateinit var signupPassword:EditText
    private lateinit var signupConfirmPassword:EditText
    private lateinit var registrationButton: Button

    private var context:Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        init()

        //Редирект на страницу с логином и паролем
        loginRedirectText.setOnClickListener {
            var intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }

        //Кнопка регистрации
        registrationButton.setOnClickListener {
            if(signupPassword.text.toString() == signupConfirmPassword.text.toString()){

                Database.addUser(User(signupUsername.text.toString(),
                    signupEmail.text.toString(),
                    signupPassword.text.toString()))
                var intent = Intent(context, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun init(){
        loginRedirectText = findViewById(R.id.loginRedirectText)
        signupUsername = findViewById(R.id.signup_username)
        signupEmail = findViewById(R.id.signup_email)
        signupPassword = findViewById(R.id.signup_password)
        signupConfirmPassword = findViewById(R.id.signup_confirm_password)
        registrationButton = findViewById(R.id.registration_button)
    }
}