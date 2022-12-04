package ru.nsu.hackatonapp.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import ru.nsu.hackatonapp.utils.LogTags

class Login : ViewModel() {
    init{
        Log.i(LogTags.LOGIN_TAG, "Hello from ${Thread.currentThread().name}")
    }
    fun login(){
        Log.i(LogTags.LOGIN_TAG, "Starting login")
    }
}