package com.example.institutepractics.models

import java.io.Serializable

class User(_name:String, _email:String, _password:String):Serializable {
    val name: String= _name
    val email: String = _email
    val password: String = _password

}