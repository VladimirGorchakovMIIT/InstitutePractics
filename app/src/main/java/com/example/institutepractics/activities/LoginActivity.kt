package com.example.institutepractics.activities

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.models.User


class LoginActivity : AppCompatActivity() {
    private val TAG: String = "MyApp"
    private lateinit var registrationUser: TextView
    private lateinit var loginUsername: EditText
    private lateinit var loginPassword: EditText
    private lateinit var loginButton: Button
    private lateinit var database: Database

    private var context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()//init Objects
        loginButton.setOnClickListener {
            if (loginUsername.text.isEmpty() || loginPassword.text.isEmpty())
                Toast.makeText(context, "Need write login or password", Toast.LENGTH_SHORT).show()

            if (Database.checkUser(loginUsername.text.toString(), loginPassword.text.toString())) {
                var intent = Intent(context, WelcomeActivity::class.java).apply {
                    Log.d(TAG, "Test application" + Database.getUser(loginUsername.text.toString()))
                    putExtra("email", Database.getUser(loginUsername.text.toString())?.name)
                    putExtra("Object", Database.getUser(loginUsername.text.toString()))
                }

                startActivity(intent)
            } else
                Toast.makeText(context, "Not correct login or password", Toast.LENGTH_SHORT).show()
        }

        registrationUser.setOnClickListener {
            var intent = Intent(context, RegistrationActivity::class.java)
            startActivity(intent)
        }

    }

    private fun init() {
        registrationUser = findViewById(R.id.loginRedirectText)
        loginUsername = findViewById(R.id.login_username)
        loginPassword = findViewById(R.id.login_password)
        loginButton = findViewById(R.id.login_button)
        database = Database();
    }
}