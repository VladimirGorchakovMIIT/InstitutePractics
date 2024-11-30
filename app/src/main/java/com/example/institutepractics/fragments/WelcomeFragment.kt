package com.example.institutepractics.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.institutepractics.databinding.FragmentWelcomeBinding
import com.example.institutepractics.network.RetrofitNetwork
import com.example.institutepractics.network.RetrofitNetworkApi
import com.example.institutepractics.network.ktor.KtorNetwork
import com.example.institutepractics.network.ktor.KtorNetworkApi
import com.example.institutepractics.unit.CharactersAdapter
import kotlinx.coroutines.launch

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    private var _retrofitApi: RetrofitNetworkApi? = null
    private val retrofitApi get() = _retrofitApi!!

    private var _ktorApi: KtorNetworkApi? = null
    private val ktorApi get() = _ktorApi!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _ktorApi = KtorNetwork()
        _retrofitApi = RetrofitNetwork()

        binding.retrofit.setOnClickListener {
            lifecycleScope.launch {
                val users = retrofitApi.getUsers()
                binding.userList.adapter = CharactersAdapter(users)
            }
        }

        binding.ktor.setOnClickListener {
            lifecycleScope.launch {
                val characters = ktorApi.getCharacters()

                Toast.makeText(context, "Count characters" + characters.size, Toast.LENGTH_SHORT).show()

                binding.userList.adapter = CharactersAdapter(characters)
            }
        }
    }

    private fun init(){

    }
}