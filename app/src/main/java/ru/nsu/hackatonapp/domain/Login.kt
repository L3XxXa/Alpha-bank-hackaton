package ru.nsu.hackatonapp.domain

import androidx.lifecycle.ViewModel

class Login : ViewModel() {
    private var _email = ""
    private var _password = ""

    val email: String
        get() = _email


}