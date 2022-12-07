package ru.nsu.hackatonapp.utils

import android.util.Log
import ru.nsu.hackatonapp.R

class FieldValidators {
    companion object {
        fun checkPassword(password: String): Boolean {
            return password!=""
        }

        fun checkLengthPassword(password: String): Boolean{
            return (password.length in 8..16)
        }

        fun confirmPassword(password1: String, password2: String): Boolean {
            return password2 == password1
        }

        fun checkEmail(email: String): Boolean {
            val regex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
            if (regex.toRegex().matches(email)) {
                return true
            }
            return false
        }
    }
}
