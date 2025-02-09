package com.example.institutepractics.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.institutepractics.MAIN_AUTHORIZATION
import com.example.institutepractics.R
import com.example.institutepractics.databinding.FragmentRegistrationBinding
import com.example.institutepractics.databinding.FragmentStartWindowBinding

class StartWindowFragment : Fragment() {
    private lateinit var binding: FragmentStartWindowBinding
    private lateinit var buttonNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartWindowBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        buttonNext.setOnClickListener{
            MAIN_AUTHORIZATION.navControllerAuthorization.navigate(R.id.action_startWindowFragment_to_loginFragment)
        }
    }

    private fun init(){
        buttonNext = binding.buttonNextPage
    }
}