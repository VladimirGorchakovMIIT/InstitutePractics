package com.example.institutepractics.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.databinding.ActivityAuthorizationBinding
import com.example.institutepractics.databinding.ActivityWelcomeBinding
import com.example.institutepractics.network.RetrofitNetwork
import com.example.institutepractics.network.RetrofitNetworkApi
import kotlinx.coroutines.launch

class AuthorizationActivity : AppCompatActivity() {
    lateinit var navControllerAuthorization: NavController
    private lateinit var binding: ActivityAuthorizationBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthorizationBinding.inflate(layoutInflater)

        setContentView(binding.root)

        navControllerAuthorization = Navigation.findNavController(this, R.id.nav_authorization_fragment_container)

        MAIN_AUTHORIZATION = this
    }
}