package ru.nsu.hackatonapp.utils

class FieldValidators {
    companion object {
        fun checkFieldNotEmpty(field: String): Boolean {
            return field!=""
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
