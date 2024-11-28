package com.example.institutepractics.activities

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.institutepractics.MAIN
import com.example.institutepractics.R
import com.example.institutepractics.databinding.ActivityWelcomeBinding
import com.example.institutepractics.models.User

class WelcomeActivity : AppCompatActivity() {
    lateinit var navController: NavController

    private val TAG: String = "MyApp"

    private lateinit var binding: ActivityWelcomeBinding
    private lateinit var underTitleNameUser: TextView
    private lateinit var nameUser: String

    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_container)

        init()

        MAIN = this
    }

    private fun init() {
        underTitleNameUser = findViewById(R.id.underTitleNameUser)
        nameUser = intent.getStringExtra("email").toString()
        user = intent.getSerializableExtra("Object") as User

        underTitleNameUser.text = nameUser
    }
}