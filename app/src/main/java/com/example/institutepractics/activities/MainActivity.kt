package com.example.institutepractics.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.institutepractics.R
import com.example.institutepractics.database.Database
import com.example.institutepractics.fragments.LoginFragment
import com.example.institutepractics.fragments.RegistrationFragment
import com.example.institutepractics.fragments.SecondFragment
import com.example.institutepractics.fragments.WelcomeFragment
import com.example.institutepractics.models.User
import com.example.institutepractics.unit.interfaces.OnNavigationApplication
import com.example.institutepractics.unit.interfaces.OnPassDataCommunicator

class MainActivity : AppCompatActivity(), OnPassDataCommunicator, OnNavigationApplication{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginFragment = LoginFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.main, loginFragment)
            .commit()
    }

    override fun passData(data: String) {
        val bundle = Bundle()
        bundle.putString("inputText", data)

        val fragment2 = SecondFragment()
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.main, fragment2)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    private fun openFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, fragment)
            .commit()
    }

    override fun openRegistrationFragment() {
        Toast.makeText(this, "Open registration fragment", Toast.LENGTH_SHORT).show()
        openFragment(RegistrationFragment())
    }

    override fun openLoginFragment() {
        openFragment(LoginFragment())
    }

    override fun openWelcomePage(data: String) {
        val welcomeFragment = WelcomeFragment()
        val user: User? = Database.getUser(data)
        val bundle = Bundle()
        bundle.putString("username", user?.name)
        bundle.putString("email", user?.email)

        welcomeFragment.arguments = bundle

        openFragment(welcomeFragment)
    }
}