package com.example.institutepractics.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding

    private lateinit var loginRedirectText:TextView

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
        
        loginRedirectText.setOnClickListener {
            Toast.makeText(context, "Переход на другой фрагемент", Toast.LENGTH_SHORT).show()
            MAIN_AUTHORIZATION.navControllerAuthorization.navigate(R.id.action_registrationFragment_to_loginFragment)
        }
        
    }

    private fun init(){
        loginRedirectText = binding.loginRedirectText
    }
}