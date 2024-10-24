package com.example.institutepractics.database

import com.example.institutepractics.models.User

class Database {
    companion object {
        private val users: MutableList<User> = mutableListOf()

        init {
            users.add(User("admin", "vova_stec@mail.ru", "admin"))
            users.add(User("1", "1@mail.ru", "1"))
        }

        fun getAllUsers(): List<User> {
            return users;
        }

        fun getUser(name: String): User? {
            var result: User? = null
            for (user in users) {
                if (user.name == name)
                    result = user
            }
            return result
        }

        fun checkUser(name: String, password: String): Boolean {
            var result: Boolean = false

            for (user in users) {
                if (user.name.equals(name) && user.password.equals(password))
                    result = true
            }

            return result
        }

        fun addUser(user: User) {
            users.add(user)
        }
    }

}